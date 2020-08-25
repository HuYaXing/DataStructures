package 蓝桥杯备战.JavaB组2016年;

/**
 * @Author HYStar
 * @Date 2020/5/27 10:37
 */
public class 抽签05 {
    public static void f(int[] a, int k, int n, String s) {
        if (k == a.length) {
            if (n == 0) {
                System.out.println(s);
            }
            return;
        }

        String s2 = s;
        for (int i = 0; i <= a[k]; i++) {
            //填空位置
            f(a, k + 1, n - i, s2);
            s2 += (char) (k + 'A');
        }
    }

    public static void main(String[] args) {
//        int[] a = {4, 2, 2, 1, 1, 3};
//        f(a, 0, 5, "");
        System.out.println(3 % 4);
    }
}