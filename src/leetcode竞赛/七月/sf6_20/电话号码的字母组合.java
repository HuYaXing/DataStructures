package leetcode竞赛.七月.sf6_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/6/20 16:08
 */
public class 电话号码的字母组合 {

    public static void main(String[] args) {
        电话号码的字母组合 main = new 电话号码的字母组合();
        System.out.println(main.letterCombinations("23"));
    }

    List<String> res = new ArrayList<>();
    Map<Integer, String> map = new HashMap<>();
    boolean[] memo = new boolean[10];

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return res;
        }
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        f(digits, "", 0);
        return res;
    }

    private void f(String digits, String path, int index) {
        if (path.length() == digits.length()) {
            res.add(path);
            return;
        }
        for (int i = index; i < digits.length(); i++) {
            int a = Integer.parseInt(digits.substring(i, i + 1));
            if (!memo[a]) {
                String b = map.get(a);
                for (int j = 0; j < b.length(); j++) {
                    String temp = path;
                    path += b.substring(j, j + 1);
                    memo[a] = true;
                    f(digits, path, index + 1);
                    memo[a] = false;
                    path = temp;
                }
            }
        }
    }

}
