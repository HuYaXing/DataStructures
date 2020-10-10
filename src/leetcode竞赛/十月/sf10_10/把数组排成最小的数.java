package leetcode竞赛.十月.sf10_10;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/10/10 下午4:39
 */
public class 把数组排成最小的数 {

    public static void main(String[] args) {
        int[] nums = {2,2812};
        System.out.println(minNumber(nums));
    }

    public static String minNumber(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            String str1 = o1 + "";
            String str2 = o2 + "";
            int len1 = str1.length();
            int len2 = str2.length();
            if (len1 == len2) {
                return o1 - o2;
            }
            int i = 0;
            for (; i < len1 && i < len2; i++) {
                if (str1.charAt(i) > str2.charAt(i)) {
                    return 1;
                } else if (str1.charAt(i) < str2.charAt(i)) {
                    return -1;
                }
            }
            if (i < len1) {
                if (str1.charAt(i) > str1.charAt(0)) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                if (str2.charAt(i) > str2.charAt(0)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (int n : nums) {
            queue.add(n);
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            res.append(queue.poll());
        }
        return res.toString();
    }

}
