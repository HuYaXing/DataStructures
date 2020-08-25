package 面试算法.笔试360;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/22 19:53
 */
public class 合法名字 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            if (lawful(str)) {
                res++;
            }
        }
        System.out.println(res);
    }

    private static boolean lawful(String str) {
        if (str == null || str.length() == 0 || str.length() > 10) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }


}
