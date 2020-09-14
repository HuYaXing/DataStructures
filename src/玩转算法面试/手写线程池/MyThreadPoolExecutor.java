package 玩转算法面试.手写线程池;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author HYStar
 * @Date 2020/9/13 10:35
 */
public class MyThreadPoolExecutor implements Executor {

    /**
     * 线程池的名称
     */
    private String name;

    /**
     * 线程序列号
     */
    private AtomicInteger sequence = new AtomicInteger(0);

    /**
     * 核心线程数
     */
    private int coreSize;

    /**
     * 最大线程数
     */
    private int maxSize;

    /**
     * 任务队列
     */
    private BlockingQueue<Runnable> taskQueue;

    /**
     * 拒绝策略
     */
    private RejectPolicy rejectPolicy;

    /**
     * 当前线程数量
     */
    private AtomicInteger runningCount = new AtomicInteger(0);

    public MyThreadPoolExecutor(String name, int coreSize, int maxSize, BlockingQueue<Runnable> taskQueue, RejectPolicy rejectPolicy) {
        this.name = name;
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.taskQueue = taskQueue;
        this.rejectPolicy = rejectPolicy;
    }

    @Override
    public void execute(Runnable task) {
        // 正在运行的线程数
        int count = runningCount.get();
        // 如果正在运行的线程数小于核心线程数，直接加一个线程
        if (count < coreSize) {
            //这里不一定添加成功，addWork中还要判断一次是否确实小
            if (addWorker(task, true)) {
                return;
            }
            //如果失败进入下面的逻辑
        }
        //如果达到了核心线程数量，先尝试进入任务队列
        //使用offer，队列满了会直接返回false
        if (taskQueue.offer(task)) {
            //do nothing
        } else {
            //如果入队失败了，说明队列已经满了，就添加一个非核心线程
            if (!addWorker(task, false)) {
                //如果添加非核心线程失败了，执行拒绝策略
                rejectPolicy.reject(task, this);
            }
        }
    }

    private boolean addWorker(Runnable newTask, boolean core) {
        //自旋判断是不是真的可以创建一个线程
        for (; ; ) {
            //正在运行的线程数
            int count = runningCount.get();
            //核心线程还是非核心线程
            int max = core ? coreSize : maxSize;
            //不满足创建条件，直接返回 false
            if (count >= max) {
                return false;
            }
            //修改runningCount成功，可以创建线程
            if (runningCount.compareAndSet(count, count + 1)) {
                //线程的名字
                String threadName = (core ? "core_" : "") + name + sequence.incrementAndGet();
                //创建线程并启动
                new Thread(() -> {
                    System.err.println("thread name:" + Thread.currentThread().getName());
                    //运行的任务
                    Runnable task = newTask;
                    //不断的从任务队列中取出任务执行，如果取出来的任务为空，就结束了
                    while ((task != null || (task = getTask()) != null) && core) {
                        try {
                            //执行任务
                            System.err.println("thread name:" + Thread.currentThread().getName() + "执行任务");
                            task.run();
                        } finally {
                            task = null;
                        }
                    }
                    System.err.println("thread name:" + Thread.currentThread().getName() + "运行结束！");
                }, threadName).start();
                break;
            }
        }
        return true;
    }

    private Runnable getTask(){
        try {
            //take会阻塞到取出任务为止
            return taskQueue.take();
        } catch (InterruptedException e) {
            // 线程中断了，返回null可以结束当前线程
            // 当线程都要结束了，应该将runningCount数量减一
            runningCount.decrementAndGet();
            return null;
        }
    }

}
