package ��ת�㷨����.�ȴ�֪ͨ����;

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
