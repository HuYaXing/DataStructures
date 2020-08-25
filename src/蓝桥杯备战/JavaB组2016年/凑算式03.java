package 蓝桥杯备战.JavaB组2016年;

/**
 * @Author HYStar
 * @Date 2020/5/27 9:30
 */
public class 凑算式03 {

    public static void main(String[] args) {
        int res = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        for (int e = 1; e <= 9; e++) {
                            for (int f = 1; f <= 9; f++) {
                                for (int g = 1; g <= 9; g++) {
                                    for (int h = 1; h <= 9; h++) {
                                        for (int i = 1; i <= 9; i++) {
                                            if (a != b && a != c && a != d && a != e && a != f && a != g && a != h && a != i
                                                    && b != c && b != d && b != e && b != f && b != g && b != h && b != i
                                                    && c != d && c != e && c != f && c != g && c != h && c != i
                                                    && d != e && d != f && d != g && d != h && d != i
                                                    && e != f && e != g && e != h && e != i
                                                    && f != g && f != h && f != i
                                                    && g != h && g != i
                                                    && h != i) {
                                                int def = d * 100 + e * 10 + f;
                                                int ghi = g * 100 + h * 10 + i;
                                                int up = b * ghi + c * def;
                                                int down = c * ghi;
                                                if (up % down == 0){
                                                    if (a + up/down == 10) {
                                                        res++;
                                                        System.out.println(a + "+" + b + "/" + c + "+" + def + "/" + ghi + "=" + 10);
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
        }
        System.out.println(res);
    }

}
