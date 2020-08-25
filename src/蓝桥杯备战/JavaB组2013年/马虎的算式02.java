package 蓝桥杯备战.JavaB组2013年;

/**
 * @Author HYStar
 * @Date 2020/5/11 10:32
 */
public class 马虎的算式02 {

    public static void main(String[] args) {
        int res = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        for (int e = 1; e <= 9; e++) {
                            int ab = a * 10 + b;
                            int cde = c * 100 + d * 10 + e;
                            int adb = a * 100 + d * 10 + b;
                            int ce = c * 10 + e;
                            if (a != b && a != c && a != d && a != e &&
                                    b != c && b != d && b != e
                                    && c != d && c != e && d != e) {
                                if (ab * cde == adb * ce) {
                                    res++;
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
