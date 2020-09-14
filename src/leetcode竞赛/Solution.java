package leetcode¾ºÈü;

/**
 * @Author HYStar
 * @Date 2020/9/11 15:09
 */
public class Solution {

    public int minMoves(int[] nums) {
        // write code here
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        sum = sum / nums.length;
        int min = Integer.MAX_VALUE;
        int val = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min > Math.abs(sum - nums[i])) {
                min = Math.abs(sum - nums[i]);
                val = nums[i];
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - val);
        }
        return res;
    }

    public int minMoves1(int[] nums) {
        // write code here
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int val = sum / nums.length;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - val);
        }
        return res;
    }

}
