package leetcode竞赛.八月.sf8_05;

/**
 * @Author HYStar
 * @Date 2020/8/5 10:01
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        删除排序数组中的重复项 main = new 删除排序数组中的重复项();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        main.removeDuplicates(nums);
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0){
            return 0;
        }
        int next = 1;
        int val = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[i] != val){
                val = nums[i];
                nums[next] = nums[i];
                next++;
            }
        }
        return next;
    }

}
