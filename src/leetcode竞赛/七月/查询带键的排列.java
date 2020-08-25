package leetcode竞赛.七月;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/4/14 16:46
 */
public class 查询带键的排列 {

    public static void main(String[] args) {
        int[] queries = {7, 5, 5, 8, 3};
        System.out.println(Arrays.toString(processQueries(queries, 8)));
    }

    public static int[] processQueries(int[] queries, int m) {

        int[] P = new int[m];
        for (int i = 1; i <= m; i++) {
            P[i - 1] = i;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i];
            res[i] = findNum(P, n);
            for (int j = res[i]; j > 0; j--) {
                P[j] = P[j - 1];
            }
            P[0] = n;
        }
        return res;
    }

    //返回n在P中的下标
    public static int findNum(int[] P, int n) {
        for (int i = 0; i < P.length; i++) {
            if (P[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
