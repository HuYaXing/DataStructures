package 算法训练;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2019/12/7 14:35
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates1(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates1(int[] nums) {
        int i = 0;
        //把所有不相等的拿过来
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static int removeDuplicates(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < res - 1; i++) {
            while(i < res - 1){
                if (nums[i] == nums[i + 1]){
                    for (int j = i + 1; j < res - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    res -= 1;
                }else{
                    break;
                }
            }
        }
        return res;
    }


}
