package leetcode竞赛.八月;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/8/28 下午6:08
 */
public class 整数1到n中1出现的次数 {

    public static void main(String[] args) {

    }

    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
