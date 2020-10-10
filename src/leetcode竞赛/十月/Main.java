package leetcode竞赛.十月;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/10/9 上午10:28
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String failPathName = "/home/huyaxing/桌面/fail.txt";
        String otherPathName = "/home/huyaxing/桌面/other.txt";
        String successPathName = "/home/huyaxing/桌面/success.txt";
        BufferedWriter fail = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(failPathName)));
        BufferedWriter other = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(otherPathName)));

        String path = "/home/huyaxing/桌面/urls.09-22-2020-15-15-44.txt";
        Set<String> uuu = new HashSet<>();
        BufferedReader in = new BufferedReader(new FileReader(path));
        String url;
        while ((url = in.readLine()) != null) {
            uuu.add(url);
        }

        for (int i = 1; i <= 5; i++) {
            String fPath = "/home/huyaxing/IdeaProjects/my_micrawler_template/src/main/resources/fail/2020-09-30_15:14:18/2020-09-30_15:14:18_" + i + ".txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fPath));
            String furl;
            while ((furl = bufferedReader.readLine()) != null) {
                if (!"".equals(furl)) {
                    fail.write(furl + "\n");
                    fail.flush();
                    uuu.remove(furl);
                }
            }
        }

        Map<String, Set<String>> urls = new HashMap<>();

        for (String u : uuu) {
            String containerid = u.split("containerid=")[1].substring(5, 16);
            Set<String> orDefault = urls.getOrDefault(containerid, new HashSet<>());
            orDefault.add(u);
            urls.put(containerid, orDefault);
        }

        BufferedWriter success = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(successPathName)));
        for (int i = 1; i <= 5; i++) {
            String tPath = "/home/huyaxing/IdeaProjects/my_micrawler_template/src/main/resources/text/2020-09-30_15:14:18/text_2020-09-30_15:14:18_" + i + ".txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(tPath));
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                String[] ids = text.split("\t");
                if (ids.length > 2) {
                    String id = ids[2];
                    if (urls.containsKey(id)) {
                        Set<String> set = urls.get(id);
                        for (String str : set) {
                            success.write(str + "\n");
                            success.flush();
                        }
                        urls.remove(id);
                    }
                }
            }
        }
        Set<String> set = urls.keySet();
        for (String str : set) {
            Set<String> ur = urls.get(str);
            for (String s : ur) {
                other.write(s + "\n");
                other.flush();
            }
        }
    }

}
