package leetcode竞赛.七月.sf7_30;

/**
 * @Author HYStar
 * @Date 2020/7/30 23:04
 */
public class 二进制中1的个数 {

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //由低位向高位判断,>>正补0，负补1；>>>正负都补0
            if (((n >>> i) & 1) == 1) {
                res++;
            }
        }
        return res;
    }

}
