package leetcode����.����.sf7_23;

/**
 * @Author HYStar
 * @Date 2020/7/23 22:45
 */
public class �滻�ո� {

    public static void main(String[] args) {
        �滻�ո� main = new �滻�ո�();
        System.out.println(main.replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
    }
}
