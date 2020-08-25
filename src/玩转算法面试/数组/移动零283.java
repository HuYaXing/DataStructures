package 玩转算法面试.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/8 21:17
 */
public class 移动零283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12, 0};
        moveZeroes(nums);
    }

    /**
     * 取出数组中所有非零元素，再放回去，不足的置为0
     * @param nums
     */
    public static void moveZeroes0(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        for (int i = list.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {

        int len = nums.length;
        if (len < 2) {
            return;
        }

        int next = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                // 遵守循环不变式：[0, i) 非零，所以先赋值，后自增
                nums[next] = nums[i];
                next++;
            }
        }

        // 把剩下的部分设置为 0
        for (int i = next; i < len; i++) {
            nums[next] = 0;
            next++;
        }

    }

}
