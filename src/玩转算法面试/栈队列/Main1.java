package 玩转算法面试.栈队列;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/4/23 19:43
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String s = scanner.nextLine();

            boolean flag = false;
            if (s.contains("-")) {
                flag = true;
                s = s.substring(1);
            }

            String suffix = "";
            String prefix = s;
            if (s.contains(".")) {
                suffix = s.substring(s.indexOf("."));
                if (suffix.length() > 2) {
                    suffix = suffix.substring(0, 3);
                } else {
                    for (int i = 0; i <= 3 - suffix.length(); i++) {
                        suffix += "0";
                    }
                }
                prefix = s.substring(0, s.indexOf("."));
            }

            char[] chars = prefix.toCharArray();
            LinkedList<String> linkedList = new LinkedList<>();
            String temp = "";
            int num = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (num == 3) {
                    linkedList.addFirst(",");
                    num = 0;
                }
                linkedList.addFirst(chars[i] + "");
                num++;
            }

            String res = String.join("", linkedList);

            if (flag) {
                System.out.println("(" + res + suffix + ")");
            } else {
                System.out.println(res + suffix);
            }

        }

    }


}
