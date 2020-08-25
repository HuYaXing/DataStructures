package leetcode竞赛.八月.sf8_02;

/**
 * @Author HYStar
 * @Date 2020/8/2 23:18
 */
public class 打印从1到最大的n位数 {

    public int[] printNumbers(int n) {
        int len = 1;
        for (int i = 0; i < n; i++) {
            len *= 10;
        }
        int[] res = new int[len - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

}
