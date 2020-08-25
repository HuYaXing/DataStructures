package leetcode竞赛.七月.sf7_24;

/**
 * @Author HYStar
 * @Date 2020/7/24 22:27
 */
public class 机器人的运动范围 {

    public static void main(String[] args) {
        机器人的运动范围 main = new 机器人的运动范围();
        System.out.println(main.movingCount(3, 1, 0));
    }

    boolean[][] memo;
    int res = 0;
    int[][] nums = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int a = 0, b = 0;

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        a = m;
        b = n;
        memo = new boolean[m][n];
        dfs(0, 0, k);
        return res;
    }

    private void dfs(int m, int n, int k) {
        if ((findNum(m) + findNum(n)) <= k && !memo[m][n]) {
            res++;
            memo[m][n] = true;
            for (int i = 0; i < 4; i++) {
                int newX = m + nums[i][0];
                int newY = n + nums[i][1];
                if (isArea(newX, newY) && !memo[newX][newY]) {
                    dfs(newX, newY, k);
                }
            }
        }
    }

    private boolean isArea(int x, int y) {
        return x >= 0 && y >= 0 && x < a && y < b;
    }

    private int findNum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
