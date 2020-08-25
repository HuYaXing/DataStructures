package 算法训练;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/1/12 17:02
 */
public class 寻找两个有序数组的中位数 {

    public static void main(String[] args) {
        System.out.println(126 == 128);
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2, 4};
//        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;

        int[] array = new int[len];

        System.arraycopy(nums1, 0, array, 0, nums1.length);
        System.arraycopy(nums2, 0, array, nums1.length, nums2.length);

        Arrays.sort(array);

        int mid = (len - 1) / 2;

        if (len % 2 == 0) {
            BigDecimal a = BigDecimal.valueOf(array[mid]);
            BigDecimal b = BigDecimal.valueOf(array[mid + 1]);
            BigDecimal res = a.add(b);
            BigDecimal c = BigDecimal.valueOf(2);
            return res.divide(c, 1, BigDecimal.ROUND_HALF_UP).doubleValue();
        } else {
            return (double) array[mid];
        }

    }

}
