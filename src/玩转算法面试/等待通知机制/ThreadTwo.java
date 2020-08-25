package 玩转算法面试.等待通知机制;

/**
 * @Author HYStar
 * @Date 2020/7/20 16:00
 */
public class ThreadTwo extends Thread{

    Consumer consumer;

    //构造注入producer
    public ThreadTwo(Consumer consumer) {
        super();
        this.consumer = consumer;
    }

    @Override
    public void run() {
        consumer.consume();
    }

}
