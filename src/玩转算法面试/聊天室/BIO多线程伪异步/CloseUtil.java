package 玩转算法面试.聊天室.BIO多线程伪异步;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author HYStar
 * @Date 2020/8/16 15:40
 */
public class CloseUtil {

    public static void closeAll(Closeable... able) {
        for (Closeable c : able) {
            if (c != null){
                try {
                    c.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
