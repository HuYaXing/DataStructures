package leetcode竞赛.春季;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/4/18 15:33
 */
public class 剧情触发时间 {

    public static void main(String[] args) {
        int[][] increase = {{2, 8, 4}, {2, 5, 0}, {10, 9, 8}};
        int[][] requirements = {{2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}};
        System.out.println(Arrays.toString(getTriggerTime(increase, requirements)));
    }

    /**
     * 暴力超时
     *
     * @param increase
     * @param requirements
     * @return
     */
    public static int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int C = 0, R = 0, H = 0;
        int[] res = new int[requirements.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for (int j = 0; j < requirements.length; j++) {
            if (C >= requirements[j][0] && R >= requirements[j][1] && H >= requirements[j][2]) {
                res[j] = 0;
            }
        }
        for (int i = 0; i < increase.length; i++) {
            C += increase[i][0];
            R += increase[i][1];
            H += increase[i][2];
            for (int j = 0; j < requirements.length; j++) {
                if (C >= requirements[j][0] && R >= requirements[j][1] && H >= requirements[j][2]) {
                    res[j] = res[j] == -1 ? i + 1 : res[j];
                }
            }
        }
        return res;
    }

    public static int[] getTriggerTime1(int[][] increase, int[][] requirements) {
        int day = 0;
        int[] ans = new int[requirements.length];
        //将increase中的三元组的含义变为每一天的属性值
        for (int i = 1; i < increase.length; i++) {
            increase[i][0] += increase[i - 1][0];
            increase[i][1] += increase[i - 1][1];
            increase[i][2] += increase[i - 1][2];
        }

        for (int i = 0; i < requirements.length; i++) {
            if (requirements[i][0] == 0 && requirements[i][1] == 0 && requirements[i][2] == 0) {
                ans[i] = 0;
            } else {
                int left = 0;
                int right = increase.length - 1;

                //如果最后一天仍不满足，设为-1
                if (increase[right][0] < requirements[i][0] ||
                        increase[right][1] < requirements[i][1] ||
                        increase[right][2] < requirements[i][2]) {
                    ans[i] = -1;
                    continue;
                }
                //二分查找
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (increase[mid][0] < requirements[i][0] ||
                            increase[mid][1] < requirements[i][1] ||
                            increase[mid][2] < requirements[i][2]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                ans[i] = left+1;
            }
        }
        return ans;
    }


}
