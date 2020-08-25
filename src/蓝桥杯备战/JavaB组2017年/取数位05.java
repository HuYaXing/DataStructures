package 蓝桥杯备战.JavaB组2017年;

/**
 * @Author HYStar
 * @Date 2020/5/29 20:16
 */
public class 取数位05 {

    static int len(int x) {
        if (x < 10) {
            return 1;
        }
        return len(x / 10) + 1;
    }


    // 取x的第k位数字
    static int f(int x, int k) {
        if (len(x) - k == 0) {
            return x % 10;
        }
        //填空
        return f(x / 10, k);
    }


    public static void main(String[] args) {
        int x = 23513;
//        System.out.println(len(x));
        System.out.println(f(x, 4));
    }

}
