package 玩转算法面试.查找表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/4/16 10:02
 */
public class 回旋镖的数量 {

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};

        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {

            Map<Integer, Integer> record = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int key = dis(points[i], points[j]);
                    record.put(key, record.getOrDefault(key, 0) + 1);
                }
            }

            List<Integer> list = new ArrayList<>(record.keySet());
            for (int j = 0; j < list.size(); j++) {
                int key1 = list.get(j);
                if (record.get(key1) >= 2) {
                    res += record.get(key1) * (record.get(key1) - 1);
                }
            }
        }
        return res;
    }

    private static int dis(int[] pa, int[] pd) {
        return (pa[0] - pd[0]) * (pa[0] - pd[0]) + (pa[1] - pd[1]) * (pa[1] - pd[1]);
    }

}
