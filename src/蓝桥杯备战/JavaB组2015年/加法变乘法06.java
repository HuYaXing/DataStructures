package 蓝桥杯备战.JavaB组2015年;

/**
 * @Author HYStar
 * @Date 2020/5/24 11:36
 */
public class 加法变乘法06 {

    public static void main(String[] args) {
        for (int i = 1; i < 47; i++) {
            for (int j = i + 2; j < 49; j++) {
                f(i, j);
            }
        }
    }

    private static void f(int i, int j) {
        int res = 0;
        for (int k = 1; k <= 49; k++) {
            if (k == i || k == j) {
                res += k * (k + 1);
                k++;
            } else {
                res += k;
            }
        }
        if (res == 2015){
            System.out.println(i);
        }
    }

}
