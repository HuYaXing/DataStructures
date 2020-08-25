package 玩转算法面试.动态规划;

/**
 * @Author HYStar
 * @Date 2020/5/4 16:00
 */
public class 解码方法 {

    public static void main(String[] args) {
        解码方法 main = new 解码方法();
        System.out.println(main.numDecodings("0"));
        System.out.println(main.numDecodings("10"));
        System.out.println(main.numDecodings("12"));
    }

    public int numDecodings(String s) {
        int[] Decoding = new int[s.length() + 1];
        Decoding[s.length()] = 1;
        if (s.charAt(s.length() - 1) == '0') {
            Decoding[s.length() - 1] = 0;
        } else {
            Decoding[s.length() - 1] = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                Decoding[i] = 0;
                continue;
            }
            String str = s.substring(i, i + 2);
            if (Integer.parseInt(str) <= 26) {
                Decoding[i] = Decoding[i + 1] + Decoding[i + 2];
            } else {
                Decoding[i] = Decoding[i + 1];
            }
        }
        return Decoding[0];
    }

}
