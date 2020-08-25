package 网易面试;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/4/7 20:07
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //n只怪物
        int n = scanner.nextInt();
        //初始防御
        int D = scanner.nextInt();
        //录入怪物破防能力
        int[] A = new int[n];
        //录入怪物伤害值
        int[] B = new int[n];
        //录入怪物破防能力
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        //录入怪物伤害值
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }
        //将破防按照大小排序
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    int temp1 = B[i];
                    B[i] = B[j];
                    B[j] = temp1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= D) {
                D++;
            }else {
                res += B[i];
            }
        }
        System.out.println(res);
    }
}