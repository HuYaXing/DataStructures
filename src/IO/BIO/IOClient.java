package IO.BIO;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @Author HYStar
 * @Date 2020/7/29 10:47
 */
public class IOClient {
    public static void main(String[] args) {
        // TODO ��������̣߳�ģ�����ͻ������ӷ����
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true) {
                    System.out.println("��������");
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();

    }

}
