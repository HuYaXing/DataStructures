package ��ת�㷨����.������.BIO���߳�α�첽;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author HYStar
 * @Date 2020/8/16 15:47
 */
public class Receive implements Runnable {

    private DataInputStream dis;
    private boolean flag = true;

    public Receive(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            flag = false;
            CloseUtil.closeAll(dis, client);
        }
    }

    private String getMessage() {
        String str = "";
        try {
            str = dis.readUTF();
        } catch (IOException e) {
            flag = false;
            CloseUtil.closeAll(dis);
        }
        return str;
    }

    @Override
    public void run() {
        while (flag){
            System.out.println(this.getMessage());
        }
    }
}
