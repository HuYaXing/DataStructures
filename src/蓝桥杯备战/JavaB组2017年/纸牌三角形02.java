package 蓝桥杯备战.JavaB组2017年;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/5/29 10:31
 */
public class 纸牌三角形02 {

    static int res = 0;

    public static void main(String[] args) {
        f(0, new LinkedList<>());
        System.out.println(res / 6);
    }

    static boolean[] memo = new boolean[10];

    private static void f(int k, LinkedList<Integer> path) {
        if (k == 9) {
            if (check(path)) {
                res++;
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!memo[i]) {
                path.addLast(i);
                memo[i] = true;
                f(k + 1, path);
                memo[i] = false;
                path.removeLast();
            }
        }
    }

    private static boolean check(LinkedList<Integer> path) {
        int a = path.get(0) + path.get(1) + path.get(2) + path.get(3);
        int b = path.get(3) + path.get(4) + path.get(5) + path.get(6);
        int c = path.get(6) + path.get(7) + path.get(8) + path.get(0);

        if (a == b && a == c) {
            return true;
        }
        return false;
    }

}
