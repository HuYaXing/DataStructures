package ��ת�㷨����.������.BIO���߳�α�첽;

import java.io.*;
import java.net.Socket;

/**
 * @Author HYStar
 * @Date 2020/8/16 15:31
 */
public class Client {

    public static void main(String[] args) throws IOException {
        System.out.println("---------�ͻ���----------");
        Socket client = new Socket("localhost",9999);
        Send send = new Send(client);
        Receive receive = new Receive(client);
        new Thread(send).start();
        new Thread(receive).start();
    }

}
