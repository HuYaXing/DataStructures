package 玩转算法面试.等待通知机制;

/**
 * @Author HYStar
 * @Date 2020/7/20 15:59
 */
public class ThreadOne extends Thread {

    Producer producer;

    public ThreadOne(Producer producer){
        super();
        this.producer = producer;
    }

    @Override
    public void run() {
        producer.producer();
    }

}
