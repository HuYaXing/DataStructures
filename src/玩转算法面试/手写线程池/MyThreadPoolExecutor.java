package ��ת�㷨����.��д�̳߳�;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author HYStar
 * @Date 2020/9/13 10:35
 */
public class MyThreadPoolExecutor implements Executor {

    /**
     * �̳߳ص�����
     */
    private String name;

    /**
     * �߳����к�
     */
    private AtomicInteger sequence = new AtomicInteger(0);

    /**
     * �����߳���
     */
    private int coreSize;

    /**
     * ����߳���
     */
    private int maxSize;

    /**
     * �������
     */
    private BlockingQueue<Runnable> taskQueue;

    /**
     * �ܾ�����
     */
    private RejectPolicy rejectPolicy;

    /**
     * ��ǰ�߳�����
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
        // �������е��߳���
        int count = runningCount.get();
        // ����������е��߳���С�ں����߳�����ֱ�Ӽ�һ���߳�
        if (count < coreSize) {
            //���ﲻһ����ӳɹ���addWork�л�Ҫ�ж�һ���Ƿ�ȷʵС
            if (addWorker(task, true)) {
                return;
            }
            //���ʧ�ܽ���������߼�
        }
        //����ﵽ�˺����߳��������ȳ��Խ����������
        //ʹ��offer���������˻�ֱ�ӷ���false
        if (taskQueue.offer(task)) {
            //do nothing
        } else {
            //������ʧ���ˣ�˵�������Ѿ����ˣ������һ���Ǻ����߳�
            if (!addWorker(task, false)) {
                //�����ӷǺ����߳�ʧ���ˣ�ִ�оܾ�����
                rejectPolicy.reject(task, this);
            }
        }
    }

    private boolean addWorker(Runnable newTask, boolean core) {
        //�����ж��ǲ�����Ŀ��Դ���һ���߳�
        for (; ; ) {
            //�������е��߳���
            int count = runningCount.get();
            //�����̻߳��ǷǺ����߳�
            int max = core ? coreSize : maxSize;
            //�����㴴��������ֱ�ӷ��� false
            if (count >= max) {
                return false;
            }
            //�޸�runningCount�ɹ������Դ����߳�
            if (runningCount.compareAndSet(count, count + 1)) {
                //�̵߳�����
                String threadName = (core ? "core_" : "") + name + sequence.incrementAndGet();
                //�����̲߳�����
                new Thread(() -> {
                    System.err.println("thread name:" + Thread.currentThread().getName());
                    //���е�����
                    Runnable task = newTask;
                    //���ϵĴ����������ȡ������ִ�У����ȡ����������Ϊ�գ��ͽ�����
                    while ((task != null || (task = getTask()) != null) && core) {
                        try {
                            //ִ������
                            System.err.println("thread name:" + Thread.currentThread().getName() + "ִ������");
                            task.run();
                        } finally {
                            task = null;
                        }
                    }
                    System.err.println("thread name:" + Thread.currentThread().getName() + "���н�����");
                }, threadName).start();
                break;
            }
        }
        return true;
    }

    private Runnable getTask(){
        try {
            //take��������ȡ������Ϊֹ
            return taskQueue.take();
        } catch (InterruptedException e) {
            // �߳��ж��ˣ�����null���Խ�����ǰ�߳�
            // ���̶߳�Ҫ�����ˣ�Ӧ�ý�runningCount������һ
            runningCount.decrementAndGet();
            return null;
        }
    }

}
