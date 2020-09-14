package 面试算法;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/13 19:42
 */
public class 破解X星人的密文 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index + n < str.length()) {
            StringBuilder sb1 = new StringBuilder(str.substring(index, index + n));
            sb.append(sb1.reverse().toString());
            index += n;
        }
        if (index < str.length()){
            StringBuilder sb1 = new StringBuilder(str.substring(index));
            sb.append(sb1.reverse().toString());
        }
        System.out.println(sb.toString());
    }

}
