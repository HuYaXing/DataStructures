package leetcode竞赛.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/6/10 17:03
 */
public class 数组中重复的数字 {

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
            //nums[i]可能为负(为负是因为这个下标对应的元素出现过了)，所以应该用绝对值表示
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                return index;
            }
            nums[index] *= (-1);
        }
        return 0;
    }


}
