package 玩转算法面试.贪心算法;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/5/8 20:01
 */
public class 无重叠区间 {

    public static void main(String[] args) {
        无重叠区间 main = new 无重叠区间();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 1}, {1, 3}};
//        Arrays.sort(intervals, (int[] o1, int[] o2) -> {
//            if (o1[0] == o2[0]) {
//                return o1[1] - o2[1];
//            }
//            return o1[0] - o2[0];
//        });
        Arrays.sort(intervals, (int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(Arrays.toString(intervals[i]));
        }
//        System.out.println(main.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (int[] o1, int[] o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int[] memo = new int[intervals.length];
        memo[0] = 1;
        int max = memo[0];
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            max = Math.max(max, memo[i]);
        }

        return intervals.length - max;
    }

    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });

        int res = 1;
        int temp = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= temp) {
                res++;
                temp = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}
