package ��ת�㷨����.̰���㷨;

/**
 * @Author HYStar
 * @Date 2020/5/8 19:49
 */
public class �ж������� {

    public static void main(String[] args) {
        �ж������� main = new �ж�������();
        System.out.println(main.isSubsequence("acb","ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int si = 0, ti = 0;

        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                if (si == s.length()) {
                    return true;
                }
                ti++;
            } else {
                ti++;
            }
        }
        return false;
    }

}
