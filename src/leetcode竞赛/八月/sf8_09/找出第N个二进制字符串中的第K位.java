package leetcode竞赛.八月.sf8_09;

/**
 * @Author HYStar
 * @Date 2020/8/9 10:42
 */
public class 找出第N个二进制字符串中的第K位 {

    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("011100110110001");
        for (int i = 5; i <= n; i++) {
            String s = reverse(sb.toString());
            sb.append("1");
            sb.append(s);
        }
        return sb.charAt(k - 1);
    }

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
        return sb.reverse().toString();
    }


}
