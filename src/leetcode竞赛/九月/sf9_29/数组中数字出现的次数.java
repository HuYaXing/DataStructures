package leetcode竞赛.九月.sf9_29;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/29 下午8:09
 */
public class 数组中数字出现的次数 {

    public static int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] res = new int[2];
        Set<Integer> set = map.keySet();
        int index = 0;
        for (Integer key : set) {
            if (index == 2) {
                break;
            }
            if (map.get(key) == 1) {
                res[index] = key;
                index++;
            }
        }
        return res;
    }

    public static int[] singleNumbers1(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, zeroCount = 0;
        for (int num: nums) {
            if (num == 0) {
                zeroCount += 1;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum ^= num;
        }
        // 需要特判一下某个数是0的情况。
        if (zeroCount == 1) {
            return new int[]{sum, 0};
        }
        int lo = min, hi = max;
        while (lo <= hi) {
            // 根据 lo 的正负性来判断二分位置怎么写，防止越界。
            int mid = (lo < 0 && hi > 0)? (lo + hi) >> 1: lo + (hi - lo) / 2;
            int loSum = 0, hiSum = 0;
            for (int num: nums) {
                if (num <= mid) {
                    loSum ^= num;
                } else {
                    hiSum ^= num;
                }
            }
            if (loSum != 0 && hiSum != 0) {
                // 两个都不为0，说明 p 和 q 分别落到2个数组里了。
                return new int[] {loSum, hiSum};
            }
            if (loSum == 0) {
                // 说明 p 和 q 都比 mid 大，所以比 mid 小的数的异或和变为0了。
                lo = mid + 1;
            } else {
                // 说明 p 和 q 都不超过 mid
                hi = mid - 1;
            }
        }
        // 其实如果输入是符合要求的，程序不会执行到这里，为了防止compile error加一下
        return null;
    }


    public static void main(String[] args) {
        System.out.println(1/2);
        int[] nums = {4, 1, 6, 4};
        singleNumbers(nums);
    }
}
