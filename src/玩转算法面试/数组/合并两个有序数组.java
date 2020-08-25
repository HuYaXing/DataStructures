package 玩转算法面试.数组;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/4/9 10:40
 */
public class 合并两个有序数组 {

    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        merge(nums1, 1, nums2, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }
        int[] temp = new int[m + n];
        int q = 0;
        int p = 0;
        for (int i = 0; i < m + n; i++) {
            if (q == m) {
                for (int j = i; j < m + n; j++) {
                    temp[j] = nums2[p];
                    p++;
                }
                break;
            }
            if (p == n) {
                for (int j = i; j < m + n; j++) {
                    temp[j] = nums1[q];
                    q++;
                }
                break;
            }
            if (nums1[q] <= nums2[p]) {
                temp[i] = nums1[q];
                q++;
            } else {
                temp[i] = nums2[p];
                p++;
            }
        }
        System.out.println(Arrays.toString(nums1));
        System.arraycopy(temp, 0, nums1, 0, temp.length);
        System.out.println(Arrays.toString(nums1));
    }
}
