package leetcode竞赛.八月;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/8/19 15:15
 */
public class 最长的可整合子数组的长度 {

    public static void main(String[] args) {
        最长的可整合子数组的长度 main = new 最长的可整合子数组的长度();
        int[] arr = {5, 5, 3, 2, 6, 4, 3};
        System.out.println(main.maxSubarrayCanbeMerged(arr));
    }

    public int maxSubarrayCanbeMerged(int[] arr) {
        // write code here
//        Proxy
        Thread thread = new Thread();
        thread.interrupt();
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            map.put(arr[i], 1);
        }
        int temp = 0;
        for (int i = min; i <= max; i++) {
            if (map.get(i) != null) {
                temp++;
            } else {
                res = Math.max(res, temp);
                temp = 0;
            }
        }
        return Math.max(res, temp);
    }


    public void f(Integer[] arr, int m) {
        Arrays.sort(arr, (o1, o2) -> {
            return Math.abs(o2 - m) - Math.abs(o1 - m);
        });
    }

}
