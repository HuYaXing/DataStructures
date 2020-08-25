package 蓝桥杯备战.JavaB组2015年;

import java.util.Scanner;
import java.util.Vector;

/**
 * @Author HYStar
 * @Date 2020/5/25 22:53
 */
public class 生命之树2 {

    static int MaxN = (int) 1e5;
    static Vector<Integer> g = new Vector<>(MaxN + 1);
    static long[] w = new long[MaxN + 1];
    static long[] ww = new long[MaxN + 1];
    static long ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g.add(u, v);
            g.add(v, u);
        }
        dfs(1,0);
        System.out.println(ans);
    }

    static void dfs(int root, int fa) {
        ww[root] = w[root];
//        for (int i = 0; i < g[root].size(); i++) {
//            int son = g[root][i];
//            if (son != fa) {
//                dfs(son, root);
//                if (ww[son] > 0){
//                    ww[root] += ww[son];
//                }
//            }
//        }
        if (ww[root] > ans){
            ans = ww[root];
        }
    }
}
