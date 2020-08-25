package 玩转算法面试.聊天室.BIO多线程伪异步;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Author HYStar
 * @Date 2020/8/16 15:35
 */
public class Send implements Runnable {

    private BufferedReader br;
    private DataOutputStream dos;

    private boolean flag = true;

    public Send(Socket client) {
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            flag = false;
            CloseUtil.closeAll(dos,client);
            e.printStackTrace();
        }
    }

    private String getMessage() {
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            flag = false;
            CloseUtil.closeAll(br);
            e.printStackTrace();
        }
        return str;
    }

    public void send(String str) {
        try {
            dos.writeUTF(str);
            dos.flush();
        } catch (IOException e) {
            flag = false;
            CloseUtil.closeAll(dos);
            e.printStackTrace();
        }
    }



    @Override
    public void run() {
        while (flag){
            this.send(getMessage());
        }
    }

}
