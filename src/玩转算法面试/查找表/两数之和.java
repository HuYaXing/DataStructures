package ��ת�㷨����.���ұ�;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/4/15 15:49
 */
public class ����֮�� {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int[] res = {i, map.get(complement)};
                return res;
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
