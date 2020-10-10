package leetcode竞赛.九月.多线程;

import java.util.Scanner;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/25 下午1:54
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println(sc.nextLine().replaceAll("\/","/"));
        String html_content = ascii2Native(sc.nextLine());
        System.out.println(ascii2Native(sc.nextLine()));
    }


    public static String ascii2Native(String str) {
        StringBuilder sb = new StringBuilder();
        int begin = 0;
        int index = str.indexOf("\\u");
        while (index != -1) {
            sb.append(str.substring(begin, index));
            sb.append(ascii2Char(str.substring(index, index + 6)));
            begin = index + 6;
            index = str.indexOf("\\u", begin);
        }
        sb.append(str.substring(begin));
        return sb.toString();
    }

    private static char ascii2Char(String str) {
        if (str.length() != 6) {
            throw new IllegalArgumentException("长度不足6位");
        }
        if (!"\\u".equals(str.substring(0, 2))) {
            throw new IllegalArgumentException("字符必须以 \"\\u\"开头.");
        }
        String tmp = str.substring(2, 4);
        int code = Integer.parseInt(tmp, 16) << 8;
        tmp = str.substring(4, 6);
        code += Integer.parseInt(tmp, 16);
        return (char) code;
    }

}
