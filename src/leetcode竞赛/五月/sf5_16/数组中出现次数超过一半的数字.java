package leetcode竞赛.五月.sf5_16;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/5/16 17:05
 */
public class 数组中出现次数超过一半的数字 {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int res = 0;
        int num = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = map.getOrDefault(nums[i],0) + 1;
            map.put(nums[i],temp);
            if (temp > num){
                res = nums[i];
                num = temp;
            }
        }
        return res;
    }
}
