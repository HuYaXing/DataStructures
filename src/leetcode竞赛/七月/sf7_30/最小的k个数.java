package leetcode竞赛.七月.sf7_30;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author HYStar
 * @Date 2020/7/30 23:16
 */
public class 最小的k个数 {

    public static void main(String[] args) {
//        Integer
        int[] arr = {0, 1, 2, 1};
        最小的k个数 main = new 最小的k个数();
        main.getLeastNumbers(arr, 1);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        System.out.println(queue.size());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
