package Ð¡ÆÆÕ¾;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author HYStar
 * @Date 2020/8/13 20:17
 */
public class Solution2 {

    public int GetCoinCount(int N) {
        // write code here
        int num = 1024 - N;
        int[] nums = {64, 16, 4, 1};
        Deque<Integer> stack = new LinkedList<>();
        stack.add(num);
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Integer poll = stack.poll();
                int me64 = poll - 64;
                int me16 = poll - 16;
                int me4 = poll - 4;
                int me1 = poll - 1;
                if (poll - nums[0] == 0 || poll - nums[1] == 0
                        || poll - nums[2] == 0 || poll - nums[3] == 0) {
                    return res + 1;
                } else if (poll - nums[0] > 0 && !set.contains(poll - nums[0])) {
                    stack.add(poll - nums[0]);
                    set.add(poll - nums[0]);
                }
                for (int j = 0; j < nums.length; j++) {
                    int a = poll - nums[j];
                    if (a > 0 && !set.contains(a)) {
                        stack.add(a);
                        set.add(a);
                    }
                }
            }
            res++;
        }
        return 0;
    }

}
