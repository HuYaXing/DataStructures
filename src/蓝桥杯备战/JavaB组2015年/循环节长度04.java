package ���ű���ս.JavaB��2015��;

import java.util.Vector;

/**
 * @Author HYStar
 * @Date 2020/5/24 10:43
 */
public class ѭ���ڳ���04 {

    public static void main(String[] args) {
        System.out.println(f(11,13));
    }

    public static int f(int n, int m) {
        n = n % m;
        Vector v = new Vector();

        for (; ; ) {
            v.add(n);
            n *= 10;
            n = n % m;
            if (n == 0) {
                return 0;
            }
            if (v.indexOf(n) >= 0) {
                //���
                return v.size() - v.indexOf(n);
            }
        }
    }
}
