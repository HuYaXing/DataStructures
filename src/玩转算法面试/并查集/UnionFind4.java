package 玩转算法面试.并查集;

/**
 * 实际上使用size数组并不是最合理的做法，元素最多不能代表高度最高
 * 所以我们引入rank数组，rank[i]代表以第i个元素为根的树的高度
 *
 * @author ：huyaxing
 * @date ：Created in 2020/9/14 下午5:06
 */
public class UnionFind4 implements IUnionFind {

    private int[] parent;

    private int[] rank;

    private int count;

    public UnionFind4(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public String versionName() {
        return "并查集的第 4 个版本，基于 parent 数组，quick-union，基于 rank";
    }

    @Override
    public int find(int p) {
//        while (p != parent[p]) {
//            p = parent[p];
//        }
//        return p;

        //路径压缩
//        while (p != parent[p]) {
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }
//        return p;
        //更加彻底的压缩
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
            p = parent[p];
        }
        return parent[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        // 这一步是与第 3 版不同的地方
        if (parent[pRoot] > parent[qRoot]) {
            parent[qRoot] = pRoot;
        } else if (parent[pRoot] < parent[qRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
        // 每次 union 以后，连通分量减 1
        count--;
    }
}
