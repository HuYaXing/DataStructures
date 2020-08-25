package 玩转算法面试.数组.指针碰撞;

/**
 * @Author HYStar
 * @Date 2020/4/9 21:16
 */
public class 验证回文串 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (right >= left) {
            //遇到非数字或字母跳过
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (right >= left && Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

}
