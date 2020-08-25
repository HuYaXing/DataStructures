package ��ת�㷨����.����.ָ����ײ;

/**
 * @Author HYStar
 * @Date 2020/4/9 21:16
 */
public class ��֤���Ĵ� {

    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (right >= left) {
            //���������ֻ���ĸ����
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
