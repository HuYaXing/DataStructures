package leetcode����.����.sf7_24;

/**
 * @Author HYStar
 * @Date 2020/7/24 22:16
 */
public class ������̨������ {

    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

}
