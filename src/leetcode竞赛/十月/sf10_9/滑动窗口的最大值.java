package leetcode����.ʮ��.sf10_9;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/10/9 ����3:09
 */
public class �������ڵ����ֵ {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1]){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]){
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if (i >= 0){
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

}
