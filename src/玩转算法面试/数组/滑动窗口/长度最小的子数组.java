package ��ת�㷨����.����.��������;

/**
 * @Author HYStar
 * @Date 2020/4/9 22:17
 */
public class ������С�������� {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        //nums[l....r]���ǻ�������
        int l = 0, r = -1;

        //������Ԫ�صĺ�
        int sum = 0;

        //��С����
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
