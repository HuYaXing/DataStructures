package 蓝桥杯备战.JavaB组2014年;

/**
 * @Author HYStar
 * @Date 2020/5/21 15:29
 */
public class 大衍数列04 {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            //填空
            if (i % 2 == 0) {
                System.out.println(i * i / 2);
            } else {
                System.out.println((i * i - 1) / 2);
            }
        }
    }

}
