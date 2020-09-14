package 玩转算法面试.手写线程池;

/**
 * @Author HYStar
 * @Date 2020/9/13 17:44
 */
public interface RejectPolicy {
    void reject(Runnable task, MyThreadPoolExecutor myThreadPoolExecutor);
}
