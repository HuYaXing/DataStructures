package leetcode竞赛.八月.sf8_24;

/**
 * @Author HYStar
 * @Date 2020/8/24 9:23
 */
public class 重复的子字符串 {

    public static void main(String[] args) {
        重复的子字符串 main = new 重复的子字符串();
        System.out.println(main.repeatedSubstringPattern("abababab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String cur = s.substring(0, i);
            if (f(s, cur)) {
                return true;
            }
        }
        return false;
    }

    private boolean f(String s, String cur) {
        if (cur.length() * 2 > s.length()) {
            return false;
        }
        for (int i = cur.length(); i < s.length(); i += cur.length()) {
            if (i + cur.length() > s.length()) {
                return false;
            }
            String str = s.substring(i,i+cur.length());
            if (!str.equals(cur)){
                return false;
            }
        }
        return true;
    }

}
