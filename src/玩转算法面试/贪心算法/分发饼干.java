package 玩转算法面试.贪心算法;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/5/8 19:22
 */
public class 分发饼干 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int si = s.length - 1, gi = g.length - 1;
        int res = 0;
        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                si--;
                gi--;
            } else {
                gi--;
            }
        }
        return res;
    }

}
