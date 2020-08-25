package 蓝桥杯备战.JavaB组2014年;

/**
 * @Author HYStar
 * @Date 2020/5/21 10:15
 */
public class 切面条02 {

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println(2 + a + b);
            a = a + b;
            b = b * 2;
        }
    }

}
