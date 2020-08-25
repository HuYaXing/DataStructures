package ��ת�㷨����.����;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/4/9 9:26
 */
public class ��ɫ����������� {

    public static void main(String[] args) {
        int[] nums = {2};
        sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        //����
        int[] count = new int[4];

        for (int i = 0; i < nums.length; i++) {
            assert (nums[i] <= 2);
            System.out.println(nums[i]);
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    //���ڷ�Χ���ޣ�����ʹ����·����
    public static void sortColors1(int[] nums) {
        //[0,zero]����0
        int zero = -1;
        //[tow,n-1]����2
        int tow = nums.length;

        for (int i = 0; i < tow; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                tow--;
                int temp = nums[i];
                nums[i] = nums[tow];
                nums[tow] = temp;
            } else {
                zero++;
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                i++;
            }
        }
    }

}
