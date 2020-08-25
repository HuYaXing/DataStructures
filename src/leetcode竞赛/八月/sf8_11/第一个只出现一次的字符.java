package leetcode竞赛.八月.sf8_11;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author HYStar
 * @Date 2020/8/11 15:55
 */
public class 第一个只出现一次的字符 {

    public static void main(String[] args) {

    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }
}
