package ��ת�㷨����.��д�̳߳�;

/**
 * @Author HYStar
 * @Date 2020/9/13 17:44
 */
public interface RejectPolicy {
    void reject(Runnable task, MyThreadPoolExecutor myThreadPoolExecutor);
}
