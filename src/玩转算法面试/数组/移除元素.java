package 玩转算法面试.数组;

/**
 * @Author HYStar
 * @Date 2020/4/8 22:37
 */
public class 移除元素 {

    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {
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
