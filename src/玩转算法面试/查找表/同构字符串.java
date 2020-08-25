package 玩转算法面试.查找表;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/4/15 8:08
 */
public class 同构字符串 {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int m = 1;
        int n = 1;
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if (!sMap.containsKey(s1)) {
                sMap.put(s1, m);
                m++;
            }
            if (!tMap.containsKey(t1)) {
                tMap.put(t1, n);
                n++;
            }
            if (!sMap.get(s1).equals(tMap.get(t1))) {
                return false;
            }
        }
        return true;
    }
}
