package �㷨ѵ��2_09;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/4/8 11:03
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //��n����
        int n = sc.nextInt();
        //��m��ۻ�
        int m = sc.nextInt();
        //��һ���˵ı�ţ�0��ʼ��
        int f = sc.nextInt();
        HashSet<Integer> infected = new HashSet<>();
        infected.add(f);
        for (int i = 0; i < m; i++) {
            int q = sc.nextInt();
            //һ�ξۻ����
            Set<Integer> set = new HashSet<>();
            //��־�Ƿ��и�Ⱦ��
            boolean inf = false;
            for (int j = 0; j < q; j++) {
                set.add(sc.nextInt());
                for (int infect : infected) {
                    if (set.contains(infect)) {
                        inf = true;
                    }
                }
            }
            if (inf) {
                infected.addAll(set);
            }
        }
        System.out.println(infected.size());
    }
}
