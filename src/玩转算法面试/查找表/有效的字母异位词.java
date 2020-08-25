package 玩转算法面试.查找表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/4/14 15:21
 */
public class 有效的字母异位词 {

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;

    }
}
