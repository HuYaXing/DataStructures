package leetcode����.����;

/**
 * @Author HYStar
 * @Date 2020/8/29 10:05
 */
public class ��̻��Ĵ� {

    public static void main(String[] args) {
        ��̻��Ĵ� main = new ��̻��Ĵ�();
        System.out.println(main.shortestPalindrome("aacecaaa"));
    }

    /**
     * ��ʱ
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, s.length() - i);
            if (isPlalind(str)) {
                StringBuilder sb = new StringBuilder(s.substring(s.length() - i));
                return sb.reverse().toString() + s;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString() + s;
    }

    private boolean isPlalind(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString().equals(str);
    }

//    public String shortestPalindrome1(String s) {
//
//    }

}
