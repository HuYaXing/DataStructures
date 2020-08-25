package leetcode竞赛.八月.sf8_23;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/8/23 10:33
 */
public class 圆形赛道上经过次数最多的扇区 {

    public static void main(String[] args) {
        圆形赛道上经过次数最多的扇区 main = new 圆形赛道上经过次数最多的扇区();
        int[] nums = {1, 3, 1, 2};
        main.mostVisited(4, nums);
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 0;
        List<Integer> res = new ArrayList<>();
        hashMap.put(rounds[0], hashMap.getOrDefault(rounds[0], 0) + 1);
        max = Math.max(max, hashMap.get(rounds[0]));
        for (int i = 0; i < rounds.length - 1; i++) {
            int num1 = rounds[i];
            int num2 = rounds[i + 1];
            if (num2 >= num1) {
                for (int j = num1 + 1; j <= num2; j++) {
                    hashMap.put(j, hashMap.getOrDefault(j, 0) + 1);
                    max = Math.max(max, hashMap.get(j));
                }
            } else {
                for (int j = 1; j <= num2; j++) {
                    hashMap.put(j, hashMap.getOrDefault(j, 0) + 1);
                    max = Math.max(max, hashMap.get(j));
                }
                for (int j = num1 + 1; j <= n; j++) {
                    hashMap.put(j, hashMap.getOrDefault(j, 0) + 1);
                    max = Math.max(max, hashMap.get(j));
                }
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        return res;
    }

}
