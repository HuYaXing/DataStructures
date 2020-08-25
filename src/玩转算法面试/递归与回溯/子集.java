package ��ת�㷨����.�ݹ������;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/29 11:17
 */
public class �Ӽ� {

    public static void main(String[] args) {
        �Ӽ� main = new �Ӽ�();
        int[] nums = {1,2,3};
        System.out.println(main.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = (int) Math.pow(2, nums.length) - 1; i >= 0; i--) {
            List<Integer> temp = new ArrayList<>();
            for (int j = nums.length - 1; j >= 0; j--) {
                if (((i >> j) & 1) == 1) {
                    temp.add(nums[j]);
                }
            }
            if (!res.contains(temp)){
                res.add(temp);
            }
        }
        return res;
    }

}
