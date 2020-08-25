package leetcode竞赛.五月.sf5_12;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/5/12 20:02
 */
public class 罗马数字转整数 {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int num = map.get(s.charAt(i));
            if (num <= temp) {
                res += num;
                temp = num;
            } else {
                res = res - 2 * temp + num;
            }
        }
        return res;
    }

}
