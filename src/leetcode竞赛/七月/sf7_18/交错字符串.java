package leetcode¾ºÈü.ÆßÔÂ.sf7_18;

/**
 * @Author HYStar
 * @Date 2020/7/18 10:06
 */
public class ½»´í×Ö·û´® {

    public static void main(String[] args) {
//        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    boolean flag = false;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        f(0, 0, 0, s1, s2, s3);
        return flag;
    }

    private void f(int p1, int p2, int p3, String s1, String s2, String s3) {
        if (flag) {
            return;
        }
        if (p3 == s3.length()) {
            flag = true;
            return;
        }
        if (p1 >= s1.length() && p2 >= s2.length()) {
            return;
        }
        if (p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3)) {
            p1++;
            p3++;
            f(p1, p2, p3, s1, s2, s3);
            p1--;
            p3--;
            Object o = new Object();
        }
        if (p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3)) {
            p2++;
            p3++;
            f(p1, p2, p3, s1, s2, s3);
            A a = new A();
        }
    }

}
class A{
    private int a;
}