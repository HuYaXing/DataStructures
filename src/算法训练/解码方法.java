package 算法训练;

/**
 * @Author HYStar
 * @Date 2019/11/21 21:36
 */
public class 解码方法 {

    public static void main(String[] args) {
        System.out.println(numDecodings1("126"));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return digui(s, 0);
    }

    //递归的套路，加一个index控制递归的层次
    private static int digui(String s, int start) {
        //递归的第一步，应该是加终止条件，避免死循环。
        if (s.length() == start) {
            return 1;
        }
        //以0位开始的数是不存在的
        if (s.charAt(start) == '0') {
            return 0;
        }
        //递归的递推式应该是如果index的后两位小于等于26，
        // digui(s, start) = digui(s, start+1)+digui(s, start+2)
        // 否则digui(s, start) = digui(s, start+1)
        int ans1 = digui(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if (ten + one <= 26) {
                ans2 = digui(s, start + 2);
            }
        }
        return ans1 + ans2;
    }

    public static int numDecodings1(String s) {
        if (s.equals("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int len = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[len];

        if (chars[len] == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }

        int ten = (s.charAt(len - 1) - '0') * 10;
        int one = (s.charAt(len) - '0');
        if (ten + one <= 26) {
            dp[len - 2] = dp[len - 1] + 1;
        } else {
            dp[len - 2] = dp[len - 1];
        }

        int index = len - 3;

        while (true) {
            int ten1 = (s.charAt(index - 1) - '0') * 10;
            int one1 = (s.charAt(index) - '0');
            if (ten1 + one1 <= 26) {
                dp[index] = dp[index + 1] + dp[index + 2];
            } else {
                dp[index] = dp[index + 1];
            }
            index--;
            if (index == 0) {
                break;
            }
        }

        return dp[0];
    }


}
