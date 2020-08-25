package ��ת�㷨����.����;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/4/9 15:19
 */
public class �����еĵ�K�����Ԫ�� {

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
            //�Ӻ���ǰ�Ƚ�
            while (end > start && nums[end] >= key) {
                //���û�бȹؼ�ֵС�ģ��Ƚ���һ����ֱ���бȹؼ�ֵС�Ľ���λ�ã�Ȼ���ִ�ǰ����Ƚ�
                end--;
            }

            if (nums[end] <= key) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }
            //��ǰ����Ƚ�
            while (end > start && nums[start] <= key) {
                //���û�бȹؼ�ֵ��ģ��Ƚ���һ����ֱ���бȹؼ�ֵ��Ľ���λ��
                start++;
            }

            if (nums[start] >= key) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            //��ʱ��һ��ѭ���ȽϽ������ؼ�ֵ��λ���Ѿ�ȷ���ˡ���ߵ�ֵ���ȹؼ�ֵС���ұߵ�ֵ���ȹؼ�ֵ�󣬵������ߵ�˳���п����ǲ�һ���ģ���������ĵݹ����
        }
        //�ݹ�

        if (nums.length - k == start) {
            return nums[start];
        } else if (nums.length - k > start) {
            return fastSort(nums, end + 1, high, k);
        } else {
            return fastSort(nums, low, start - 1, k);
        }
    }
}
