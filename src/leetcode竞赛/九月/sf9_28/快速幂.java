package leetcode竞赛.九月.sf9_28;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/28 下午7:29
 */
public class 快速幂 {

    public static void main(String[] args) {
        System.out.println(myPow(2, 16));
    }

    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, N);
    }

    private static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

}
