package 玩转算法面试.数组.滑动窗口;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/4/10 16:16
 */
public class 最小覆盖子串 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int start = 0;
        int minLen = s.length() + 1;
        int left = 0;
        int right = 0;
        int num = 0;

        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();

        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                windows.put(c1, windows.getOrDefault(c1, 0) + 1);
                if (windows.get(c1).equals(needs.get(c1))){
                    num++;
                }
            }

            right++;
            while (num == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char c2 = s.charAt(left);
                if (windows.containsKey(c2)) {
                    windows.put(c2, windows.get(c2) - 1);
                    //防止存在多个相同的，删除后仍然符合条件的情况
                    if (windows.get(c2) < needs.get(c2)) {
                        num--;
                    }
                }
                left++;
            }
        }

        return minLen == s.length() + 1 ? "" : s.substring(start, start + minLen);

    }

}
