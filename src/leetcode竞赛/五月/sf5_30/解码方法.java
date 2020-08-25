package leetcode竞赛.五月.sf5_30;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/5/30 16:04
 */
public class 解码方法 {

    public static void main(String[] args) {
        解码方法 main = new 解码方法();
        System.out.println(main.numDecodings("27"));
    }

    Set<String> num = new HashSet<>();
    Map<String, String> map = new HashMap<>();

    public int numDecodings(String s) {
        if ("".equals(s) || "0".equals(s)) {
            return 0;
        }
        for (int i = 0; i < 26; i++) {
            map.put((i + 1) + "", (char) ('A' + i) + "");
        }
        f(s, "", 0);
        return num.size();
    }

    private void f(String s, String path, int index) {
        if (index >= s.length()) {
            num.add(path);
            return;
        }

        String a = s.substring(index, index + 1);
        if (map.containsKey(a)) {
            f(s, path + map.get(a), index + 1);
        }
        if (index < s.length() - 1) {
            String b = s.substring(index, index + 2);
            if (map.containsKey(b)) {
                f(s, path + map.get(b), index + 2);
            }
        }
    }

}
