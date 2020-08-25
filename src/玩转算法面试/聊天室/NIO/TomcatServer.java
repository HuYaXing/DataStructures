package 玩转算法面试.聊天室.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/8/16 22:41
 */
public class TomcatServer {

    static ByteBuffer byteBuffer = ByteBuffer.allocate(512);
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
            serverSocket.bind(socketAddress);
            serverSocket.configureBlocking(false);
            while (true) {
                for (SocketChannel socketChannel : channelList) {
                    int read = socketChannel.read(byteBuffer);
                    if (read > 0){
                        System.out.println("read------111---"+read);
                        byteBuffer.flip();
                        byte[] bs = new byte[read];
                        byteBuffer.get(bs);
                        String content = new String(bs);
                        System.out.println(content);
                        byteBuffer.flip();
                    }else if (read < 0){

                    }
                }
                SocketChannel accept = serverSocket.accept();
                if (accept != null){
                    System.out.println("conn success");

                    accept.configureBlocking(false);
                    channelList.add(accept);
                    System.out.println(channelList.size()+"list---size");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
