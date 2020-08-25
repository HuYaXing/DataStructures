package 算法训练;

/**
 * @Author HYStar
 * @Date 2019/11/23 15:34
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        String s = "";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        //截取n到一个
        for (int i = n; i > 0; i--) {
            //依次从第一到第n个截取
            for (int j = 0; j < n; j++) {
                //判断是否越界
                if (i + j > n) {
                    break;
                }
                String res = s.substring(j, j + i);
                if (isHuiWen(res)) {
                    return res;
                }
            }
        }
        return "";
    }

    public static boolean isHuiWen(String str) {
        char[] chars = str.toCharArray();
        int top = 0;
        int base = chars.length - 1;
        while (true) {
            if (top >= base) {
                return true;
            }
            if (chars[top] != chars[base]) {
                return false;
            }
            top++;
            base--;
        }
    }
}
