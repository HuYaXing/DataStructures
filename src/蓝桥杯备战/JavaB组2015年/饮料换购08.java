package ���ű���ս.JavaB��2015��;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/25 9:06
 */
public class ���ϻ���08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = n;
        while (n >= 3){
            int num = n / 3;
            res += num;
            n = n % 3 + num;
        }
        System.out.println(res);
    }

}
