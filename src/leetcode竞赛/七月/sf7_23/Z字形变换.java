package leetcode竞赛.七月.sf7_23;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/7/23 21:54
 */
public class Z字形变换 {

    public static void main(String[] args) {
        System.out.println(convert("A", 2));
    }

    public static String convert(String s, int numRows) {
        if (s == null || "".equals(s)){
            return "";
        }
        Map<Integer, StringBuilder> res = new HashMap<>();
        int index = 0, num = -1;
        for (int i = 0; i < s.length(); i++) {
            if (index == 0 || index == numRows - 1) {
                num *= -1;
            }
            StringBuilder sb = res.get(index) == null ? new StringBuilder() : res.get(index);
            sb.append(s.charAt(i));
            res.put(index, sb);
            index += num;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            stringBuilder.append(res.get(i).toString());
        }
        return stringBuilder.toString();
    }

}
