package 玩转算法面试.递归与回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/27 20:31
 */
public class 复原IP地址 {

    int n;
    String s;
    LinkedList<String> segments = new LinkedList<>();
    ArrayList<String> output = new ArrayList<>();


    public boolean valid(String segment) {
        int m = segment.length();
        if (m > 3) {
            return false;
        }
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }

    public void update_output(int curr_pos) {
        String segment = s.substring(curr_pos + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    //该函数使用上一个放置的点 prev_pos
    //和待放置点的数量 dots 两个参数
    public void backtrack(int prev_pos, int dots) {
        int max_pos = Math.min(n - 1, prev_pos + 4);
        for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
            String segment = s.substring(prev_pos + 1, curr_pos + 1);
            if (valid(segment)) {
                segments.add(segment);
                if (dots == 1) {
                    update_output(curr_pos);
                } else {
                    backtrack(curr_pos, dots - 1);
                }
                segments.removeLast();
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }

}
