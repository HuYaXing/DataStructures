package leetcode����.����.sf8_23;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/23 20:02
 */
public class ɾ���ڵ�1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (i != k - 1) {
                System.out.println(val + " ");
            }
        }
    }
}
