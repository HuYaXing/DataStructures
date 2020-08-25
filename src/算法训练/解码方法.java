package �㷨ѵ��;

/**
 * @Author HYStar
 * @Date 2019/11/21 21:36
 */
public class ���뷽�� {

    public static void main(String[] args) {
        System.out.println(numDecodings1("126"));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return digui(s, 0);
    }

    //�ݹ����·����һ��index���Ƶݹ�Ĳ��
    private static int digui(String s, int start) {
        //�ݹ�ĵ�һ����Ӧ���Ǽ���ֹ������������ѭ����
        if (s.length() == start) {
            return 1;
        }
        //��0λ��ʼ�����ǲ����ڵ�
        if (s.charAt(start) == '0') {
            return 0;
        }
        //�ݹ�ĵ���ʽӦ�������index�ĺ���λС�ڵ���26��
        // digui(s, start) = digui(s, start+1)+digui(s, start+2)
        // ����digui(s, start) = digui(s, start+1)
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
