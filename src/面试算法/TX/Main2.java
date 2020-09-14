package √Ê ‘À„∑®.TX;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/9/6 20:22
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int[] nums = new int[num];
            for (int j = 0; j < num; j++) {
                nums[j] = sc.nextInt();
            }
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    HashSet<Integer> set = map.getOrDefault(nums[j], new HashSet<>());
                    set.add(nums[k]);
                    map.put(nums[j], set);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int res = 0;
        boolean[] memo = new boolean[n];
        while (!queue.isEmpty()) {
            int index = queue.poll();
            HashSet<Integer> set = map.get(index);
            for (Integer num : set) {
                if (!memo[num]) {
                    memo[num] = true;
                    res++;
                    queue.add(num);
                }
            }
        }
        System.out.println(res);
    }

}
