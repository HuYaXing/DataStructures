package ��ת�㷨����.������.BIO���߳�α�첽.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/8/16 15:55
 */
public class Server {
    public static List<MyChannel> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("---------�����----------");
        ServerSocket server = new ServerSocket(9999);

//        DataInputStream dis = new DataInputStream(socket.getInputStream());
//        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        while (true){
            //����������
            Socket socket = server.accept();
            MyChannel channel = new MyChannel(socket);
            list.add(channel);
            new Thread(channel).start();
//            String str = dis.readUTF();
//            System.out.println("�ͻ��˷��͵����ݣ�" + str);
//            dos.writeUTF("������յ��ˣ�"+str);
        }
//        CloseUtil.closeAll(dis,dos,socket);
    }

}
