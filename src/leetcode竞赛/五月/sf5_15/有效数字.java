package leetcode����.����.sf5_15;

/**
 * @Author HYStar
 * @Date 2020/5/17 10:38
 */
public class ��Ч���� {

    public static void main(String[] args) {

    }

    public boolean isNumber(String s) {
        s = s.trim();
        try{
            Double.valueOf(s);
            if(s.charAt(s.length() - 1) == 'f' || s.charAt(s.length() - 1) == 'D') {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
