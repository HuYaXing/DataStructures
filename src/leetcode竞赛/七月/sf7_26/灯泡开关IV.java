package leetcode竞赛.七月.sf7_26;

/**
 * @Author HYStar
 * @Date 2020/7/26 10:34
 */
public class 灯泡开关IV {

    public int minFlips(String target) {
        int res = 0;
        int index = 1;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == index + '0') {
                res++;
                index = index == 1 ? 0 : 1;
            }
        }
        return res;
    }

}
