package 蓝桥杯备战.JavaB组2014年;

/**
 * @Author HYStar
 * @Date 2020/5/21 15:33
 */
public class 圆周率05 {

    public static void main(String[] args) {
        double x = 111;
        for (int n = 10000; n >= 0; n--) {
            int i = 2 * n + 1;
            x = 2 + (i * i / x);
        }
        System.out.println(String.format("%.4f", 4 / (x - 1)));
    }

}
