package leetcode竞赛.五月.sf5_16;

/**
 * @Author HYStar
 * @Date 2020/5/16 19:16
 */
public class 数字1的个数 {

    public static void main(String[] args) {

    }

    /**
     * 暴力 超时
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                if (temp % 10 == 1) {
                    res++;
                }
                temp = temp / 10;
            }
        }
        return res;
    }

    int countDigitOne1(int n) {
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        return count;
    }

}
