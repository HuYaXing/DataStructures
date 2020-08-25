package 面试算法.美团;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/22 16:04
 */
public class 小美的用户名 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if (lawful(s)) {
                System.out.println("Accept");
            } else {
                System.out.println("Wrong");
            }
        }
    }

    private static boolean lawful(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char one = s.charAt(0);
        if (!Character.isLetter(one)) {
            return false;
        }
        boolean flag = false;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                flag = true;
            } else if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return flag;
    }

}
