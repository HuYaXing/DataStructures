package 面试算法.搜狗;

/**
 * @Author HYStar
 * @Date 2020/9/5 22:49
 */
public class 分割字符串的方案数 {

    public int numWays(String s) {
        int nums3 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                nums3++;
            }
        }
        if (nums3 % 3 != 0) {
            return 0;
        }

        int num = nums3 / 3;
        for (int i = 0; i < s.length() - 2; i++) {

            for (int j = i + 1; j < s.length() - 1; j++) {
                for (int k = j + 1; k < s.length(); k++) {

                }
            }
        }
        return 0;
    }

}
