package 蓝桥杯备战.JavaB组2016年;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/5/27 20:18
 */
public class Main {

    public static void main(String[] args) {
        int[][] a = {{1, 1, 1}};
        int b = 9;
        StringBuilder c = new StringBuilder();
        c.append("aaa");
        f(a, b,c);
        System.out.println(b);
        System.out.println(c.toString());
        System.out.println(Arrays.toString(a[0]));
    }

    private static void f(int[][] gg, int b,StringBuilder g) {
        gg[0][0] = 0;
        b = 5;
        g.append("bbbb");
    }

}
