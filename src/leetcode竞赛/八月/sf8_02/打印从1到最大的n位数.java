package leetcode����.����.sf8_02;

/**
 * @Author HYStar
 * @Date 2020/8/2 23:18
 */
public class ��ӡ��1������nλ�� {

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
