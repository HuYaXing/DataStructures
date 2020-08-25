package leetcode¾ºÈü.°ËÔÂ.sf8_05;

/**
 * @Author HYStar
 * @Date 2020/8/5 9:45
 */
public class ÒÆ³ıÔªËØ {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int next = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[next] = nums[i];
                next++;
            }
        }
        return next;
    }

}
