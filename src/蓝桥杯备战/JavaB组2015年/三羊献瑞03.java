package 蓝桥杯备战.JavaB组2015年;

/**
 * @Author HYStar
 * @Date 2020/5/24 10:17
 */
public class 三羊献瑞03 {

    public static void main(String[] args) {
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    for (int d = 0; d <= 9; d++) {
                        for (int m = 1; m <= 9; m++) {
                            for (int n = 0; n <= 9; n++) {
                                for (int p = 0; p <= 9; p++) {
                                    int x = a * 1000 + b * 100 + c * 10 + d;
                                    int y = m * 1000 + n * 100 + p * 10 + b;
                                    int res = m * 1000 + n * 100 + c * 10 + b;

                                    if ((x + y) / 10 == res) {
                                        if (a != b && a != c && a != d && a != m && a != n &&
                                                a != p && b != c && b != d && b != m && b != n &&
                                                b != p && c != d && c != m && c != n && c != p &&
                                                d != m && d != n && d != p && m != n && m != p &&
                                                n != p) {
                                            System.out.println(x + "+" + y + "=" + (x + y));
                                            System.out.println(res);
                                            System.out.println("--------------");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
