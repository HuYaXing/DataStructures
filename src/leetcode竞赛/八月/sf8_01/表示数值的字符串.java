package leetcode竞赛.八月.sf8_01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/8/1 23:04
 */
public class 表示数值的字符串 {

    public static void main(String[] args) {

    }

    public boolean isNumber(String s) {
//        Map[] states = {
//                new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
//                new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1.
//                new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
//                new HashMap<>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
//                new HashMap<>() {{ put('d', 3); }},                                        // 4.
//                new HashMap<>() {{ put('s', 6); put('d', 7); }},                           // 5.
//                new HashMap<>() {{ put('d', 7); }},                                        // 6.
//                new HashMap<>() {{ put('d', 7); put(' ', 8); }},                           // 7.
//                new HashMap<>() {{ put(' ', 8); }}                                         // 8.
//        };
//        int p = 0;
//        char t;
//        for (char c : s.toCharArray()) {
//            if (c >= '0' && c <= '9') {
//                t = 'd';
//            } else if (c == '+' || c == '-') {
//                t = 's';
//            } else if (c == '.' || c == 'e' || c == 'E' || c == ' ') {
//                t = c;
//            } else {
//                t = '?';
//            }
//            if (!states[p].containsKey(t)) {
//                return false;
//            }
//            p = (int) states[p].get(t);
//        }
//        return p == 2 || p == 3 || p == 7 || p == 8;
        return true;
    }

}
