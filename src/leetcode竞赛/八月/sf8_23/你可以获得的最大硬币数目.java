package leetcode竞赛.八月.sf8_23;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/8/23 11:04
 */
public class 你可以获得的最大硬币数目 {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int res = 0;
        for (int i = n + 1; i < piles.length - 1; i += 2) {
            res += piles[i];
        }
        return res;
    }

}
