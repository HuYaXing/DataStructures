package ��ת�㷨����.�ȴ�֪ͨ����;

/**
 * @Author HYStar
 * @Date 2020/7/20 16:00
 */
public class ThreadTwo extends Thread{

    Consumer consumer;

    //����ע��producer
    public ThreadTwo(Consumer consumer) {
        super();
        this.consumer = consumer;
    }

    @Override
    public void run() {
        consumer.consume();
    }

}
