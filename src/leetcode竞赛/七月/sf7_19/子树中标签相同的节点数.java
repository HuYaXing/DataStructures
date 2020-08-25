package leetcode竞赛.七月.sf7_19;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author HYStar
 * @Date 2020/7/19 10:39
 */
public class 子树中标签相同的节点数 {

    public static void main(String[] args) {
        子树中标签相同的节点数 main = new 子树中标签相同的节点数();
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}
        };
        int[][] edges1 = {
                {0, 1}, {1, 2}, {0, 3}
        };
        int[][] edges2 = {
                {0, 1}, {0, 2}, {1, 3}, {0, 4}
        };
        int[][] edges3 = {
                {0, 2}, {0, 3}, {1, 2}
        };
//        ConcurrentHashMap
//        System.out.println(Arrays.toString(main.countSubTrees(7, edges, "abaedcd")));
//        System.out.println(Arrays.toString(main.countSubTrees(4, edges1, "bbbb")));
//        System.out.println(Arrays.toString(main.countSubTrees(5, edges2, "aabab")));
        System.out.println(Arrays.toString(main.countSubTrees(4, edges3, "aeed")));
    }

    boolean[] memo;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        memo = new boolean[n];
        memo[0] = true;

        int[] res = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = labels.charAt(i);
            int temp = 1;
            queue.add(i);
            while (!queue.isEmpty()) {
                int num = queue.poll();
                for (int j = 0; j < edges.length; j++) {
                    if (edges[j][0] == num) {
                        queue.add(edges[j][1]);
                        if (ch == labels.charAt(edges[j][1])) {
                            temp++;
                        }
                    }
                }
            }
            res[i] = temp;
        }
        return res;
    }
}
