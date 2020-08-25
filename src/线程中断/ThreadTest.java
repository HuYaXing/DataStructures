package �߳��ж�;

/**
 * @Author HYStar
 * @Date 2020/5/23 15:15
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        StopThread thread = new StopThread();
        thread.start();
        // ����1�룬ȷ���߳̽�������
        Thread.sleep(1000);
        // ��ͣ�߳�
//        thread.stop();
      thread.interrupt();
        // ȷ���߳��Ѿ�����
        while (thread.isAlive()) { }
        // ������
        thread.print();
    }

    private static class StopThread extends Thread {

        private int x = 0; private int y = 0;

        @Override
        public void run() {
            // ����һ��ͬ��ԭ�Ӳ���
            synchronized (this) {
                ++x;
                try {
                    // ����3��,ģ���ʱ����
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ++y;
            }
        }

        public void print() {
            System.out.println("x=" + x + " y=" + y);
        }
    }
}
