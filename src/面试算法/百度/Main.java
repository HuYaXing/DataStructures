package 面试算法.百度;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/3 18:49
        */
public class Main {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int num0 = 0;
//        int num5 = 0;
//        for (int i = 0; i < n; i++) {
//            if (sc.nextInt() == 0) {
//                num0++;
//            } else {
//                num5++;
//            }
//        }
//        System.out.println(f(num0, num5));
        System.out.println(2 & 1);
    }

    private static String f(int num0, int num5) {
        int num = num5 / 9;
        if (num0 == 0 || num5 == 0 || num == 0) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        String str = "555555555";
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        for (int i = 0; i < num0; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

}
