package leetcode竞赛.九月.sf9_04;

import javafx.util.Pair;

import java.util.*;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/7 下午12:56
 */
public class 前K个高频元素 {

    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> integers = map.keySet();
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        });
        for (Integer index : integers) {
            queue.add(new Pair<>(index, map.get(index)));
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

}
