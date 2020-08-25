package 算法训练2_09;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/4/8 10:40
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int D = scanner.nextInt();

        Pint[] pints = new Pint[n];

        //录入怪物破防能力
        for (int i = 0; i < n; i++) {
            pints[i] = new Pint();
            pints[i].A = scanner.nextInt();
        }
        //录入怪物伤害值
        for (int i = 0; i < n; i++) {
            pints[i].B = scanner.nextInt();
        }

        Arrays.sort(pints, (a, b) -> a.A - b.A);

        int res = 0;
        for (int i = 0; i < pints.length; i++) {
            if (pints[i].A <= D) {
                D++;
            } else {
                res += pints[i].B;
            }
        }
        System.out.println(res);
    }

}

class Pint {

    int A;

    int B;

    public Pint() {

    }
}