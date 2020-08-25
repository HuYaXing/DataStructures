package �㷨ѵ��;

/**
 * @Author HYStar
 * @Date 2019/11/23 15:34
 */
public class ������Ӵ� {

    public static void main(String[] args) {
        String s = "";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        //��ȡn��һ��
        for (int i = n; i > 0; i--) {
            //���δӵ�һ����n����ȡ
            for (int j = 0; j < n; j++) {
                //�ж��Ƿ�Խ��
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
