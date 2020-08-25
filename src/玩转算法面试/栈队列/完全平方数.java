package 玩转算法面试.栈队列;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/21 21:01
 */
public class 完全平方数 {

    public static void main(String[] args) {
//        System.out.println(numSquares2(7));
        boolean[] visited = new boolean[1];
        System.out.println(visited[0]);
    }

    /**
     * 动态规划  numSquares(n) = min(numSquares(n - k) + 1)
     *
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int max_square_index = (int) Math.sqrt(n) + 1;
        int[] square_nums = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 贪心枚举
     *
     * @param n
     * @return
     */
    static Set<Integer> square_nums = new HashSet<>();

    public static int numSquares1(int n) {
        square_nums.clear();

        for (int i = 1; i * i < n; i++) {
            square_nums.add(i * i);
        }

        int count = 1;

        for (; count <= n; count++) {
            if (is_divided_by(n, count)) {
                return count;
            }
        }
        return count;
    }

    protected static boolean is_divided_by(int n, int count) {
        if (count == 1) {
            return square_nums.contains(n);
        }

        for (Integer square : square_nums) {
            if (is_divided_by(n - square, count - 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 贪心 + BFS（广度优先搜索）
     *
     * @param n
     * @return
     */
    public static int numSquares2(int n) {
        ArrayList<Integer> square_nums = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }

        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);

        int level = 0;
        while (queue.size() > 0) {
            level += 1;
            Set<Integer> next_queue = new HashSet<Integer>();

            for (Integer remainder : queue) {
                for (Integer square : square_nums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }

    /**
     * @param n
     * @return
     */
    public static int numSquares3(int n) {
        //具体第几个数字，经历几段路径到达
        Queue<Pair2> q = new LinkedList<>();

        //一步也没走
        q.add(new Pair2(n, 0));
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!q.isEmpty()) {
            int num = q.peek().v1;
            int step = q.peek().v2;
            q.poll();

            if (num == 0) {
                return step;
            }
            for (int i = 1; num - i * i >= 0; i++) {
                //有可能存在相同的元素，存在性能问题
                if (!visited[num - i * i]) {
                    q.add(new Pair2(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }
        return -1;
    }

}

class Pair2 {
    int v1;

    int v2;

    public Pair2(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
}