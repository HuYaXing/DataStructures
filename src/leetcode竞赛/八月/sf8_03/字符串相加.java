package leetcode竞赛.八月.sf8_03;

/**
 * @Author HYStar
 * @Date 2020/8/3 9:00
 */
public class 字符串相加 {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            stringBuilder.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        return stringBuilder.reverse().toString();
    }

}
