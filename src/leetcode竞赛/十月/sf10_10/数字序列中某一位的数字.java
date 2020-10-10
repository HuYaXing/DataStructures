package leetcode竞赛.十月.sf10_10;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/10/10 下午4:18
 */
public class 数字序列中某一位的数字 {

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

}
