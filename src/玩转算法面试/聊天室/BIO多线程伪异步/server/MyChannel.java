package ��ת�㷨����.������.BIO���߳�α�첽.server;

import ��ת�㷨����.������.BIO���߳�α�첽.CloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/8/16 16:06
 */
public class MyChannel implements Runnable {

    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean flag = true;

    public MyChannel(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            flag = false;
            CloseUtil.closeAll(dis, dos);
            Server.list.remove(this);
        }
    }

    private String receive() {
        String str = "";
        try {
            str = dis.readUTF();
        } catch (IOException e) {
            flag = false;
            CloseUtil.closeAll(dis);
            Server.list.remove(this);
        }
        return str;
    }

    private void send(String str) {
        if (str != null && str.length() != 0) {
            try {
                dos.writeUTF(str);
                dos.flush();
            } catch (IOException e) {
                flag = false;
                CloseUtil.closeAll(dos);
                Server.list.remove(this);
            }
        }
    }

    private void sendOther() {
        String str = this.receive();
        List<MyChannel> list = Server.list;
        for (MyChannel other : list) {
            if (other == this) {
                continue;
            }
            other.send(str);
        }
    }

    @Override
    public void run() {
        while (flag) {
            sendOther();
//            send(receive());
        }
    }

}
