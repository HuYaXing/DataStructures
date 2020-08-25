package 蓝桥杯备战.JavaB组2014年;

import java.math.BigDecimal;

/**
 * @Author HYStar
 * @Date 2020/5/21 15:50
 */
public class 奇怪的分式06 {

    public static void main(String[] args) {

        System.out.println(3 % 4);
        System.out.println(4 % 3);
        System.out.println(1 % 4);
        System.out.println(2 % 4);
        System.out.println(5 % 4);


        System.out.println(gcd(3, 4));

        int res = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        if (i != j && k != l) {
                            int gcd1 = gcd(i * k, j * l);
                            int gcd2 = gcd(i * 10 + k, j * 10 + l);

                            if (i * k / gcd1 == (i * 10 + k) / gcd2 && j * l / gcd1 == (j * 10 + l) / gcd2) {
                                res++;
                                System.out.println("(" + i + "/" + j + ")" + "*" + "(" + k + "/" + l + ")" + "==");
                            }
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
