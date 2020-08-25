package sf3_21;

/**
 * @Author HYStar
 * @Date 2020/3/21 22:22
 */
public class 回文子串 {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int count = s.length();
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j < s.length() - 1; j++) {
                if ((j + i) <= s.length() && isHuiWen(s.substring(j, j + i))) {
                    count++;
                }
            }
        }
        return count;
    }

    //判断是否是回文
    public static boolean isHuiWen(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
