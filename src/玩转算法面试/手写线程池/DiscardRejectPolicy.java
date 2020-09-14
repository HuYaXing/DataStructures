package 玩转算法面试.手写线程池;

/**
 * @Author HYStar
 * @Date 2020/9/13 17:44
 */
public class DiscardRejectPolicy implements RejectPolicy {

    @Override
    public void reject(Runnable task, MyThreadPoolExecutor myThreadPoolExecutor) {
        //do nothing
        System.err.println("discard one task!");
    }

}
