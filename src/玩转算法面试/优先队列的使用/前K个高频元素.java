package 玩转算法面试.优先队列的使用;

import javafx.util.Pair;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/24 17:11
 */
public class 前K个高频元素 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent1(nums, k)));
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        //注意 ArrayList<>() 括号里要传入map.entrySet()
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//        list.sort((o1,o2) -> {
//            return o2.getValue() - o1.getValue();
//        });
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //按照value值，重小到大排序
//                return o1.getValue() - o2.getValue();

                //按照value值，从大到小排序
                return o2.getValue() - o1.getValue();

                //按照value值，用compareTo()方法默认是从小到大排序
//                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

    //使用优先队列
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>(5,(o1,o2) -> {
            return o1.getValue() - o2.getValue();
        });
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            Integer value = map.get(key);
            if (queue.size() == k) {
                if (value > queue.peek().getValue()) {
                    queue.poll();
                    queue.add(new Pair<>(key, value));
                }
            } else {
                queue.add(new Pair<>(key, value));
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i] = queue.remove().getKey();
            i++;
        }
        return res;
    }

}