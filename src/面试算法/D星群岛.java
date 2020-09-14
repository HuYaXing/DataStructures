package √Ê ‘À„∑®;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/13 19:59
 */
public class D–«»∫µ∫ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            boolean flag;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            UF uf = new UF(n);
            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int value = sc.nextInt();
                if (value <= k) {
                    uf.union(a - 1, b - 1);
                }
            }
            flag = uf.count() == 1;
            String res = flag ? "Yes" : "No";
            System.out.println(res);
        }
    }

}

class UF {
    private int count;
    private int[] parent;
    private int[] size;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }

}