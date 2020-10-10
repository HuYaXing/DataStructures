package leetcode竞赛.九月.sf9_29;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.nio.ByteBuffer;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/30 下午1:42
 */
public class Image {

    public static void main(String[] args) throws IOException {
        String path = "/home/huyaxing/桌面/002TLsr9ly1gipg1cznncg60ao0800zf02.gif";
        String[] paths = path.split("/");
        String file = paths[paths.length - 1];
        System.out.println(file);
        ByteBuffer byteBuffer = readFileToByteBuffer(path);
        byte[] bytes = byteBuffer != null ? byteBuffer.array() : new byte[0];

        if (bytes != null && bytes.length > 0) {
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            BufferedImage image = ImageIO.read(in);
            ImageIO.write(image, "gif", new File("/home/huyaxing/桌面/temp.gif"));
        }
    }

    public static ByteBuffer readFileToByteBuffer(String filepath1) {
        try {
            File file1 = new File(filepath1);
            InputStream is = new FileInputStream(file1);
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            int count = 0;
            byte[] b = new byte[8 * 1024];
            while ((count = is.read(b)) != -1) {
                out.write(b, 0, count);
            }
            is.close();
            return ByteBuffer.wrap(out.toByteArray());
        } catch (Exception e) {
            return null;
        }
    }
}
