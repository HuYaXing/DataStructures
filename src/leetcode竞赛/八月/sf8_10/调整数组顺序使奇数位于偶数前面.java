package leetcode����.����.sf8_10;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/8/10 22:25
 */
public class ��������˳��ʹ����λ��ż��ǰ�� {

    public static void main(String[] args) {
//        System.out.println(2 & 1);
//        System.out.println(4 & 1);
        int[] nums = {2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        ��������˳��ʹ����λ��ż��ǰ�� main = new ��������˳��ʹ����λ��ż��ǰ��();
        System.out.println(Arrays.toString(main.exchange(nums)));
    }

    public int[] exchange(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                //����
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        return nums;
    }

}
