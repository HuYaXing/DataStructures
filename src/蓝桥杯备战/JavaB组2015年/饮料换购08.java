package 蓝桥杯备战.JavaB组2015年;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/25 9:06
 */
public class 饮料换购08 {

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
