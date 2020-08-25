package 面试算法.美团;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/22 16:59
 */
public class 跑腿代购 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>(m, (o1, o2) -> {
            if (o2.getValue().equals(o1.getValue())){
                return o1.getKey() - o2.getKey();
            }
            return o2.getValue() - o1.getValue();
        });
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            int nums = v + 2 * w;
            Pair<Integer, Integer> pair = new Pair<>(i + 1, nums);
            queue.add(pair);
        }
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = queue.poll().getKey();
        }
        Arrays.sort(res);
        for (int i = 0; i < m; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
