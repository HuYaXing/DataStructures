package À„∑®—µ¡∑2_09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/4/8 10:10
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        List<Long> longs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
            if (i > 1) {
                long temp = arr[i] - arr[i - 1];
                if (temp < 0) {
                    System.out.println(-1);
                    return;
                }
                longs.add(temp);
            }
        }

        if (longs.size() == 0) {
            System.out.println(-1);
            return;
        }

        if (longs.size() == 1) {
            System.out.println(longs.get(0));
            return;
        }
        long res = longs.get(0);
        for (int i = 1; i < longs.size(); i++) {
            res = dns(res, longs.get(i));
        }

        System.out.println(res == 0 ? -1 : res);
    }

    public static long dns(long a, long b) {
        if (b == 0) {
            return a;
        }
        return dns(b, a % b);
    }

}
