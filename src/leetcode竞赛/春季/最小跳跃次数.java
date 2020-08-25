package leetcode竞赛.春季;

/**
 * @Author HYStar
 * @Date 2020/4/18 16:10
 */
public class 最小跳跃次数 {

    public static void main(String[] args) {
        int[] jump = {2, 5, 1, 1, 1, 1};
        System.out.println(minJump(jump));
    }

    public static int minJump(int[] jump) {
        int[] dp = new int[jump.length];
        int left = jump.length;
        for (int i = jump.length - 1; i >= 0; i--) {
            if (i + jump[i] > jump.length - 1) {
                left = i;
                dp[i] = 1;
            }
        }
        int count = 1;
        while (dp[0] == 0) {
            int temp = -1;
            for (int i = jump.length - 1; i > left; i--) {
                if (dp[i] == 0) {
                    dp[i] = count + 1;
                    temp = i;
                }
            }
            for (int i = left - 1; i >= 0; i--) {
                if(dp[i] != 0){
                    continue;
                }
                int dst = i + jump[i];
                if(dst < jump.length && dst >= left && dp[dst] == count){
                    dp[i] = dp[dst] + 1;
                    temp = i;
                }
            }
            left = temp;
            count++;
        }
        return dp[0];
    }
}
