import javafx.util.Pair;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/7/29 17:25
 */
public class ÖÖ²Ý {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        Queue<Integer> queue = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int num = queue.poll();
            queue.add(num + x);
        }
        System.out.println(queue.poll());
    }

}
