package leetcode竞赛.七月.sf7_26;

/**
 * @Author HYStar
 * @Date 2020/7/26 8:10
 */
public class 和为s的两个数字 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int split_index = (l + r) >> 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[]{nums[l], nums[r]};
            } else if (nums[l] + nums[r] < target) {
                if (nums[split_index] + nums[r] < target){
                    l = split_index + 1;
                    split_index = (l + r) >> 1;
                }else if (nums[ split_index]+nums[r] > target){
                    l += 1;
                    split_index = (l + split_index) >> 1;
                } else{
                    return new int[]{nums[r], nums[split_index]};
                }
            } else {
                if (nums[split_index] + nums[l] > target) {
                    r = split_index - 1;
                    split_index = (l + r) >> 1;
                } else if (nums[split_index] + nums[l] < target) {
                    r -= 1;
                    split_index = (r + split_index) >> 1;
                } else {
                    return new int[]{nums[l], nums[split_index]};
                }
            }
        }
        return new int[]{0, 0};
    }

}
