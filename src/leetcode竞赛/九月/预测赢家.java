package leetcode¾ºÈü.¾ÅÔÂ;

/**
 * @author £ºhuyaxing
 * @date £ºCreated in 2020/9/1 ÏÂÎç7:23
 */
public class Ô¤²âÓ®¼Ò {

    public static void main(String[] args) {
        Ô¤²âÓ®¼Ò main = new Ô¤²âÓ®¼Ò();
        int[] nums = {1, 1};
        System.out.println(main.PredictTheWinner(nums));
    }

    int[][] memo;

    /**
     * µİ¹é¼Ó¼ÇÒä»¯ËÑË÷
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        memo = new int[nums.length][nums.length];
        return dfs(nums, 0, nums.length - 1, 1) >= 0;
    }

    private int dfs(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        if (memo[start][end] != 0){
            return memo[start][end];
        }
        int scoreStart = nums[start] * turn + dfs(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + dfs(nums, start, end - 1, -turn);
        memo[start][end] = Math.max(scoreStart * turn, scoreEnd * turn) * turn;
        return memo[start][end];
    }



}
