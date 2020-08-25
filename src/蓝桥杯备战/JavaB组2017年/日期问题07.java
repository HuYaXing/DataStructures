package 蓝桥杯备战.JavaB组2017年;

import javafx.scene.input.DataFormat;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author HYStar
 * @Date 2020/7/17 10:39
 */
public class 日期问题07 {

    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        int a = 0, b = 0, c = 0;
        a = (in.charAt(0) - '0') * 10 + (in.charAt(1) - '0');
        b = (in.charAt(3) - '0') * 10 + (in.charAt(4) - '0');
        c = (in.charAt(6) - '0') * 10 + (in.charAt(7) - '0');

        String case1 = f(a, b, c);
        String case2 = f(c, a, b);
        String case3 = f(c, b, a);

        Set<String> ans = new TreeSet<>();
        if ("".equals(case1)) {
            ans.add(case1);
        }
        if ("".equals(case2)) {
            ans.add(case2);
        }
        if ("".equals(case3)) {
            ans.add(case3);
        }
        for (String s : ans) {
            System.out.println(s);
        }
    }

    private static String f(int a, int b, int c) {

        if (a >= 0 && a <= 59) {
            a += 2000;
        } else if (a >= 60 && a <= 99) {
            a += 1900;
        } else {
            return "";
        }

        if (b < 1 || b > 12) {
            return "";
        }
        if (c < 1 || c > 31) {
            return "";
        }

        boolean _isLeap = isLeap(a);

        switch (b) {
            case 2:
                if (_isLeap && c > 29) {
                    return "";
                }
                if (!_isLeap && c > 29) {
                    return "";
                }
                break;
            case 4:
                if (c > 30) {
                    return "";
                }
                break;
            case 6:
                if (c > 30) {
                    return "";
                }
                break;
            case 9:
                if (c > 30) {
                    return "";
                }
                break;
            case 11:
                if (c > 30) {
                    return "";
                }
                break;
            default:
                break;
        }
        return "";
    }

}
