package leetcode����.ʮ��.sf10_10;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/10/10 ����4:18
 */
public class ����������ĳһλ������ {

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
