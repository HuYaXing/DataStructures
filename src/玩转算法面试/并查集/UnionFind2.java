package 玩转算法面试.并查集;

/**
 * 此版本是最基本的并查集版本，后续有两个优化：
 * 1.按秩合并（2个版本）
 * 2.路径压缩（2个版本）
 * 核心思想是【代表元法】，用树的根节点代表元
 * 使用parent数组，parent[i]代表索引为i的节点的父亲节点的索引
 *
 * @author ：huyaxing
 * @date ：Created in 2020/9/14 下午4:31
 */
public class UnionFind2 implements IUnionFind {

    /**
     * 第i个元素，存放它的父元素索引
     */
    private int[] parent;

    /**
     * 联通分量的数量
     */
    private int count;

    public UnionFind2(int n) {
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    @Override
    public String versionName() {
        return "并查集的第 2 个版本，基于 parent 数组，quick-union";
    }

    @Override
    public int find(int p) {
        //跟随链接找到根节点,如果不是根节点
        while(parent[p] != p){
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        // 如果 p 和 q 已经在相同的分量之中，则什么都不做
        if (pRoot == qRoot){
            return;
        }
        //反过来也可以，后续版本会对这一步进行优化
        parent[pRoot] = qRoot;
        count--;
    }
}
