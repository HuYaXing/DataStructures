package leetcode竞赛.八月.sf8_10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/8/10 21:49
 */
public class 计数二进制子串 {

    public static void main(String[] args) {
        String s = "00110011";
        计数二进制子串 main = new 计数二进制子串();
        System.out.println(main.countBinarySubstrings(s));
    }

    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }

}
