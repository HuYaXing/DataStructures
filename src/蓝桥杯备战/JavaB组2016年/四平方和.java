package 蓝桥杯备战.JavaB组2016年;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/5/28 10:29
 */
public class 四平方和 {
    static int N;
    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for (int c = 0; c * c <= N / 2; ++c) {
            for (int d = c; c * c + d * d <= N; ++d) {
                if (!cache.containsKey(c * c + d * d)) {
                    cache.put(c * c + d * d, c);
                }
            }
        }

        for (int a = 0; a * a <= N / 4; ++a) {
            for (int b = a; a * a + b * b <= N / 2; ++b) {
                if (cache.containsKey(N - a * a - b * b)) {
                    int c = cache.get(N - a * a - b * b);
                    int d = (int) Math.sqrt(N - a * a - b * b - c * c);
                    System.out.println(a + " " + b + " " + c + " " + d);
                    return;
                }
            }
        }

    }

}
