package 面试算法.百度;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/9/3 20:05
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < m; j++) {
                int k = sc.nextInt();
                if (j == 0) {
                    for (int l = 0; l < k; l++) {
                        int left = sc.nextInt();
                        int right = sc.nextInt();

                        for (int o = left; o <= right; o++) {
                            set.add(o);
                        }
                    }
                } else {
                    Set<Integer> temp = new HashSet<>();
                    for (int l = 0; l < k; l++) {
                        int left = sc.nextInt();
                        int right = sc.nextInt();
                        for (int o = left; o <= right; o++) {
                            if (set.contains(o)) {
                                temp.add(o);
                            }
                        }
                    }
                    set = new HashSet<>(temp);
                }
            }
            System.out.println(set.size());
            for (Integer num : set) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}