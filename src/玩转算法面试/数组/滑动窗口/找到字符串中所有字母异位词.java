package 玩转算法面试.数组.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/10 10:32
 */
public class 找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        String s = "abaacbabc";
        String p = "abc";
        System.out.println(findAnagrams1(s, p));
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        // 用数组记录答案
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;

        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();

        for (char ch : p.toCharArray()) {
            needs.put(ch, needs.getOrDefault(ch, 0) + 1);
        }

        int match = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                windows.put(c1, windows.getOrDefault(c1, 0) + 1);
                if (windows.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                // 如果 window 的大小合适
                // 就把起始索引 left 加入结果
                if (right - left == p.length()) {
                    res.add(left);
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    windows.put(c2, windows.get(c2) - 1);
                    if (windows.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();

        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();

        //用total检测窗口中是否已经涵盖了p中的字符
        int left = 0, right = 0, total = 0;

        for (char ch : p.toCharArray()) {
            needs.put(ch, needs.getOrDefault(ch, 0) + 1);
        }

        while (right < s.length()) {
            char chr = s.charAt(right);
            if (needs.containsKey(chr)) {
                windows.put(chr, windows.getOrDefault(chr, 0) + 1);
                if (windows.get(chr).equals(needs.get(chr))) {
                    total++;
                }
                while (windows.get(chr) > needs.get(chr)) {
                    char ch1 = s.charAt(left);
                    windows.put(ch1, windows.get(ch1) - 1);
                    if (!windows.get(ch1).equals(needs.get(ch1))) {
                        total--;
                    }
                    left++;
                }
            } else {
                total = 0;
                windows = new HashMap<>();
                left = right + 1;
            }
            right++;
            if (total == needs.size()) {
                res.add(left);
                char ch1 = s.charAt(left);
                windows.put(ch1, windows.get(ch1) - 1);
                total--;
                left++;
            }
        }
        return res;
    }


    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) {
            return res;
        }

        int[] freq = new int[256];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i)] += 1;
        }
        int[] temp = new int[256];
        System.arraycopy(freq, 0, temp, 0, freq.length);
        int l = 0;
        int r = -1;

        int num = 0;
        while (l < s.length()) {
            if (num == p.length()) {
                res.add(l);
                num = 0;
                l++;
                r = l - 1;
                System.arraycopy(temp, 0, freq, 0, freq.length);
            }

            if (r + 1 >= s.length()) {
                return res;
            }

            if (freq[s.charAt(r + 1)] > 0) {
                r++;
                freq[s.charAt(r)]--;
                num++;
            } else {
                num = 0;
                l++;
                r = l - 1;
                System.arraycopy(temp, 0, freq, 0, freq.length);
            }

        }
        return res;
    }

}
