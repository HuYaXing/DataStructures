package leetcode����.��ָOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/6/10 17:03
 */
public class �������ظ������� {

    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1) {
                return num;
            }
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //nums[i]����Ϊ��(Ϊ������Ϊ����±��Ӧ��Ԫ�س��ֹ���)������Ӧ���þ���ֵ��ʾ
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                return index;
            }
            nums[index] *= (-1);
        }
        return 0;
    }


}
