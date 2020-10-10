package leetcode����.ʮ��.sf10_9;

import java.util.Arrays;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/10/9 ����4:43
 */
public class �˿����е�˳�� {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCnt = 0, diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            } else {
                if (nums[i] == nums[i + 1]) {
                    return false;
                }
                if (nums[i] + 1 != nums[i + 1]) {
                    diff += nums[i + 1] - nums[i] - 1;
                }
            }
        }
        return zeroCnt >= diff;
    }

}
