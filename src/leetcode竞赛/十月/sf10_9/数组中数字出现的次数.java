package leetcode竞赛.十月.sf10_9;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/10/9 下午2:27
 */
public class 数组中数字出现的次数 {

    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int n : nums) {
            x ^= n;
        }
        int div = 1;
        while ((div & x) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

}
