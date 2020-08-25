package 面试算法.网易提前批;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/7/21 19:01
 */
public class 翻转数 {

    public static void main(String[] args) {
        int[][] node_data_list = {{1, 0}, {2, 1}, {3, 1}};
        int[][] res = invert_tree(node_data_list);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public static int[][] invert_tree(int[][] node_data_list) {
        int index = 1;
        int[][] res = new int[node_data_list.length][2];
        boolean[] memo = new boolean[node_data_list.length];
        memo[0] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        queue.add(node_data_list[0][0]);
        res[0] = node_data_list[0];

        while (!queue.isEmpty()){
            int num = queue.poll();
            for (int i = 1; i < node_data_list.length; i++) {
                if (!memo[i] && node_data_list[i][1] == num){
                    memo[i] = true;
                    queue.add(node_data_list[i][0]);
                    stack.push(i);
                }
            }
            while (!stack.isEmpty()){
                res[index] = node_data_list[stack.pop()];
                index++;
            }
        }

        return res;
    }

}
