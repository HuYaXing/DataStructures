package leetcode竞赛.七月.sf7_21;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/7/21 22:00
 */
public class 并查集 {

    public int findCircleNum() {
        Scanner scanner = new Scanner(System.in);
        //积木数量
        int n = scanner.nextInt();
        //二进制位数
        int m = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }


        System.out.println();

        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                if (M[i][j] == 1){
//                    uf.union(i, j);
//                }
            }
        }

        return uf.count();
    }

}

class UF{
    //记录连通分量
    private int count;
    //节点x的节点是parent[x]
    private int[] parent;
    // 新增一个数组记录树的“重量”
    private int[] size;

    /**
     * 构造方法。n为图的节点总数
     */
    public UF(int n){
        //一开始互不连通
        this.count = n;
        //父节点指针初始指向自己
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ){
            return;
        }

        // 小树接到大树下面，较平衡
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

    /**
     * 返回某个节点的根节点
     * @param x
     * @return
     */
    private int find(int x){
        //根节点的parent[x] = x;
        while (parent[x] != x){
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /* 返回当前的连通分量个数 */
    public int count() {
        return count;
    }

}
