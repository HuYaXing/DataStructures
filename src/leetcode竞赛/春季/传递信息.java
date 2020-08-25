package leetcode竞赛.春季;

/**
 * @Author HYStar
 * @Date 2020/4/18 15:12
 */
public class 传递信息 {

    public static void main(String[] args) {
        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};

        System.out.println(numWays(5, relation, 3));
    }

    /**
     * @param n        n个小朋友
     * @param relation 关系
     * @param k        经过k轮
     * @return 方案数
     */
    public static int numWays(int n, int[][] relation, int k) {
        return dfs(n, relation, k, n - 1);

    }

    static int dfs(int n, int[][] relation, int k, int tail) {
        if (k == 1) {
            int num = 0;
            for (int i = 0; i < relation.length; i++) {
                if (relation[i][1] == tail && relation[i][0] == 0) {
                    num++;
                }
            }
            return num;
        }

        int res = 0;
        for (int i = 0; i < relation.length; i++) {
            int time = 0;
            if (relation[i][1] == tail) {
                time = dfs(n, relation, k - 1, relation[i][0]);
            }
            res += time;
        }
        return res;
    }
}
