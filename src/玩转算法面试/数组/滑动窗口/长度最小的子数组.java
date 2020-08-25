package 玩转算法面试.数组.滑动窗口;

/**
 * @Author HYStar
 * @Date 2020/4/9 22:17
 */
public class 长度最小的子数组 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        //nums[l....r]就是滑动窗口
        int l = 0, r = -1;

        //窗口中元素的和
        int sum = 0;

        //最小长度
        int res = nums.length + 1;

        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if (sum >= s) {
                res = Math.min(res, r - l + 1);
                System.out.println(res);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }

}
