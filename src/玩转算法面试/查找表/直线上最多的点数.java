package 玩转算法面试.查找表;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/16 10:27
 */
public class 直线上最多的点数 {

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(6);
//        list.add(3);
//        list.add(0);
//        Collections.sort(list);
//        System.out.println(list);
//        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};;
        int[][] points = {{0, 0}, {94911151, 94911150}, {94911152, 94911151}};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    String key = slope(points[i], points[j]);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            int zero = map.getOrDefault("zero", 0);
            List<Integer> list = new ArrayList<>(map.values());
            Collections.sort(list, Comparator.comparingInt(item -> -item));
            if (list.size() == 1) {
                list.add(0);
            }
            if (list.size() > 0) {
                if (list.get(0) > zero) {
                    res = res > list.get(0) ? res : (list.get(0) + zero);
                } else {
                    res = res > list.get(1) ? res : (list.get(1) + zero);
                }
            }
        }
        return res + 1;
    }

    private static String slope(int[] x, int[] y) {
        if (x[1] == y[1] && x[0] == y[0]) {
            return "zero";
        }
        if (x[1] == y[1]) {
            return "No";
        }
        if (x[0] == y[0]) {
            return "0";
        }
        double v1 = ((double) y[1] - (double) x[1]);
        double v2 = ((double) y[0] - (double) x[0]);
        return div(v1, v2, 20) + "";
    }

    public static BigDecimal div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
    }


}
