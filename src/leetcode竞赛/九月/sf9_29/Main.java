package leetcode竞赛.九月.sf9_29;

import java.io.*;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/30 上午10:30
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String successPathName = "/home/huyaxing/桌面/success.txt";
        BufferedWriter successWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(successPathName)));
        for (int i = 1; i <= 5; i++) {
            String path = "/home/huyaxing/IdeaProjects/my_micrawler_template/src/main/resources/success/2020-09-30_09:59:54/2020-09-30_09:59:54_" + i +
                    ".txt";
            BufferedReader in = new BufferedReader(new FileReader(path));
            String data = "";
            while ((data = in.readLine()) != null) {
                if (!data.trim().isEmpty() && "url".equals(data.substring(0, 3))) {
                    String str = data.substring(3);
                    System.out.println(str);
                    successWriter.write(str + "\n");
                }
            }
        }


    }

}
