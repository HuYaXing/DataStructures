package leetcode竞赛.八月.sf8_24;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/24 11:03
 */
public class 自动换行 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                flag = false;
                sb.append((char) (s.charAt(i) - 32));
                continue;
            }
            if (s.charAt(i) == 'n') {
                System.out.println(sb.toString());
                sb = new StringBuilder();
                sb.append("N");
                continue;
            }
            sb.append(s.charAt(i));
        }
        if (sb.length() > 0) {
            System.out.println(sb.toString());
        }
    }

}
