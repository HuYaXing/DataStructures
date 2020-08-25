package leetcode竞赛.七月;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/14 16:17
 */
public class 数组中的字符串匹配 {

    public static void main(String[] args) {
        String[] words = {"leetcoder", "leetcode", "od", "hamlet", "am" };
        System.out.println(stringMatching(words));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isSubstring(words[i], words[j])) {
                    if (words[i].length() < words[j].length()) {
                        list.add(words[i]);
                    } else {
                        list.add(words[j]);
                    }
                }
            }
        }
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    public static boolean isSubstring(String s1, String s2) {
        if (s1.length() > s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        return s2.contains(s1);
    }

}
