package ��ת�㷨����.����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/8 21:17
 */
public class �ƶ���283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12, 0};
        moveZeroes(nums);
    }

    /**
     * ȡ�����������з���Ԫ�أ��ٷŻ�ȥ���������Ϊ0
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
                // ����ѭ������ʽ��[0, i) ���㣬�����ȸ�ֵ��������
                nums[next] = nums[i];
                next++;
            }
        }

        // ��ʣ�µĲ�������Ϊ 0
        for (int i = next; i < len; i++) {
            nums[next] = 0;
            next++;
        }

    }

}
