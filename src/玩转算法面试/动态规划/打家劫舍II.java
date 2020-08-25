package ��ת�㷨����.��̬�滮;

/**
 * @Author HYStar
 * @Date 2020/5/5 10:40
 */
public class ��ҽ���II {

    public static void main(String[] args) {
        ��ҽ���II main = new ��ҽ���II();
        int[] nums = {1, 2, 1, 1};
        System.out.println(main.rob(nums));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //ȡ����һ��Ԫ�ص�ʱ��
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }


        int[] dp1 = new int[len];
        dp1[len - 1] = nums[len - 1];
        dp1[len - 2] = Math.max(nums[len - 1], nums[len - 2]);

        //��ȡ����һ��Ԫ�ص�ʱ��
        for (int i = len - 3; i > 0; i--) {
            dp1[i] = Math.max(dp1[i + 1], dp1[i + 2] + nums[i]);
        }
        return Math.max(dp[len - 2], dp1[1]);
    }

}
