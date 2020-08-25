package 玩转算法面试.查找表;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/4/14 9:36
 */
public class 两个数组的交集 {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        Set<Integer> res = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        int[] nums = new int[res.size()];
        Iterator<Integer> iterator = res.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            nums[i] = iterator.next();
            i++;
        }
        return nums;
    }

}
