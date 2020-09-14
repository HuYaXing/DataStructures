package 玩转算法面试.并查集;

/**
 * 按秩合并1.0  基于size的优化  union-find 算法的实现（加权 quick-union 算法）
 * 为了使得树的平均深度尽量的小，引入size数组
 * size[i] 的定义是：以第i个节点为根的集合元素的个数
 * 初始化size[i] = 1，将size小的根链接在size大的根下面
 *
 * @author ：huyaxing
 * @date ：Created in 2020/9/14 下午4:46
 */
public class UnionFind3 implements IUnionFind {

    /**
     * 第 i 个元素存放它的父元素的索引
     */
    private int[] parent;

    /**
     * 连通分量的数量
     */
    private int count;

    /**
     * 以当前索引为根的树所包含的元素的总数
     */
    private int[] size;

    public UnionFind3(int n) {
        this.count = n;
        this.size = new int[n];
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            //初始化的时候，每个元素只包含它自己，只有一个元素
            size[i] = 1;
        }
    }

    @Override
    public String versionName() {
        return "并查集的第 3 个版本，基于 parent 数组，quick-union，基于 size";
    }

    @Override
    public int find(int p) {
        while (parent[p] != p) {
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

        if (pRoot == qRoot) {
            return;
        }

        // 这一步是与第 2 版不同的地方，我们不是没有根据地把一个结点的根结点的父结点指向另一个结点的根结点
        // 而是将小树的根结点连接到大树的根结点
        if (size[pRoot] > size[qRoot]){
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }else {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        count--;
    }
}
