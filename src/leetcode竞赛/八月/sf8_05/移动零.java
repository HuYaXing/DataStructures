package leetcode竞赛.八月.sf8_05;

/**
 * @Author HYStar
 * @Date 2020/8/5 9:29
 */
public class 移动零 {

    public void moveZeroes(int[] nums) {
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                //也可以直接交换，之后就不需要对数组后面的数据处理了
                nums[next] = nums[i];
                next++;
            }
        }
        for (int i = next; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
