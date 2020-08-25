package 蓝桥杯备战.JavaB组2016年;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/28 10:29
 */
public class 四平方和08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        //预处理
        int[] square = new int[(int) Math.sqrt(N)];
        for (int i = 1; i <= (int) Math.sqrt(N); i++) {
            square[i - 1] = i * i;
        }

        f(square, N, new LinkedList<>());
        System.out.println(res);
    }

    static List<LinkedList<Integer>> res = new LinkedList<>();

    private static void f(int[] square, int N, LinkedList<Integer> path) {
        if (N > 0 && path.size() == 4) {
            return;
        }
        if (N == 0) {
            if (path.size() == 4) {
                res.add(new LinkedList<>(path));
            } else {
                int size = path.size();
                for (int i = 0; i < 4 - size; i++) {
                    path.addLast(0);
                }
                res.add(new LinkedList<>(path));
                for (int i = 0; i < 4 - size; i++) {
                    path.removeLast();
                }
            }
            return;
        }

        for (int i = square.length - 1; i >= 0; i--) {
            if (N >= square[i]) {
                path.addLast(i + 1);
                f(square, N - square[i], path);
                path.removeLast();
            }
        }

    }

}
