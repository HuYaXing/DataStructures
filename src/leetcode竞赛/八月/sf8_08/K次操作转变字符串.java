package leetcode竞赛.八月.sf8_08;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/8/8 22:45
 */
public class K次操作转变字符串 {

    public static void main(String[] args) {
        String s = "atmtxzjkz";
        String t = "tvbtjhvjd";
        K次操作转变字符串 main = new K次操作转变字符串();
        System.out.println(main.canConvertString(s, t, 35));
    }

    public boolean canConvertString(String s, String t, int k) {
        int m = k / 26;
        int n = k % 26;
        if (s.length() != t.length()) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>(27);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                int num = t.charAt(i) - s.charAt(i);
                if (num < 0) {
                    num += 26;
                }
                int temp = num <= n ? m + 1 : m;
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (map.get(num) > temp){
                    return false;
                }
            }
        }
        return true;
    }

}
