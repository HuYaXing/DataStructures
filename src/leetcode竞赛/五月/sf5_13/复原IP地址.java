package leetcode竞赛.五月.sf5_13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/5/13 16:37
 */
public class 复原IP地址 {

    public static void main(String[] args) {
        复原IP地址 main = new 复原IP地址();
        System.out.println(main.restoreIpAddresses("25525511135"));
    }


    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        f(s, 0, new LinkedList<>(), 0);
        return res;
    }

    private void f(String s, int index, List<String> path, int size) {
        if (path.size() == 4) {
            if (index == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb.append(path.get(i));
                    sb.append(".");
                }
                sb.append(path.get(3));
                res.add(sb.toString());
            }
            return;
        }
        String sb = "";
        if (path.size() > size) {
            sb = path.get(size);
        }
        for (int i = index; i < s.length(); i++) {
            sb += s.charAt(i);
            if (Integer.parseInt(sb) <= 255) {
                path.add(sb);
                f(s, index + 1, path, size + 1);
                path.remove(path.size() - 1);
                f(s, index + 1, path, size);
            } else {
                int len = path.get(path.size() - 1).length();
                path.remove(path.size() - 1);
                f(s, index - len, path, size - 1);
            }
        }
    }
}
