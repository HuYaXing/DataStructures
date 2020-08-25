package 玩转算法面试.聊天室.BIO多线程伪异步.server;

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
        System.out.println("---------服务端----------");
        ServerSocket server = new ServerSocket(9999);

//        DataInputStream dis = new DataInputStream(socket.getInputStream());
//        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        while (true){
            //方法会阻塞
            Socket socket = server.accept();
            MyChannel channel = new MyChannel(socket);
            list.add(channel);
            new Thread(channel).start();
//            String str = dis.readUTF();
//            System.out.println("客户端发送的数据：" + str);
//            dos.writeUTF("服务端收到了："+str);
        }
//        CloseUtil.closeAll(dis,dos,socket);
    }

}
