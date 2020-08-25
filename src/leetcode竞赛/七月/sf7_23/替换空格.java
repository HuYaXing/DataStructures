package leetcode¾ºÈü.ÆßÔÂ.sf7_23;

/**
 * @Author HYStar
 * @Date 2020/7/23 22:45
 */
public class Ìæ»»¿Õ¸ñ {

    public static void main(String[] args) {
        Ìæ»»¿Õ¸ñ main = new Ìæ»»¿Õ¸ñ();
        System.out.println(main.replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
    }
}
