package 玩转算法面试.数组;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/4/9 15:19
 */
public class 数组中的第K个最大元素 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(findKthLargest1(nums, 1));
    }

    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i >= 0; i--) {
            if (k == 1) {
                return nums[i];
            }

            k--;

        }
        return -1;
    }





    public static int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        return fastSort(nums, start, end, k);
    }

    public static int fastSort(int[] nums, int low, int high, int k) {
        int start = low;
        int end = high;
        int key = nums[low];

        while (end > start) {
            //从后往前比较
            while (end > start && nums[end] >= key) {
                //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            }

            if (nums[end] <= key) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }
            //从前往后比较
            while (end > start && nums[start] <= key) {
                //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            }

            if (nums[start] >= key) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归

        if (nums.length - k == start) {
            return nums[start];
        } else if (nums.length - k > start) {
            return fastSort(nums, end + 1, high, k);
        } else {
            return fastSort(nums, low, start - 1, k);
        }
    }
}
