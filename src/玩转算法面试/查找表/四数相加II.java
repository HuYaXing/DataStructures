package 玩转算法面试.查找表;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/4/15 21:39
 */
public class 四数相加II {

    public static void main(String[] args) {
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                map.put(C[i] + D[j], map.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (map.containsKey(0 - A[i] - B[j])) {
                    res += map.get(0 - A[i] - B[j]);
                }
            }
        }
        return res;
    }

}
