package 玩转算法面试.并查集;

import 玩转算法面试.并查集.IUnionFind;

/**
 * 基于id的quick-find思路，并不常用，作为了解
 * find操作非常高效，但是union操作需要遍历整个数组
 *
 * @author ：huyaxing
 * @date ：Created in 2020/9/14 下午4:18
 */
public class UnionFind1 implements IUnionFind {

    /**
     * 分量id
     */
    private int[] id;

    /**
     * 连通分量的数量
     */
    private int count;

    public UnionFind1(int n) {
        this.id = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public String versionName() {
        return "并查集的第 1 个版本，基于 id 数组，quick-find";
    }

    /**
     * 以常数时间复杂度，返回分量的标识符，与并查集的规模是无关的，这一步很快
     * 因此我们称这个版本的并查集是 quick-find
     *
     * @param p
     * @return
     */
    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);

        //如果已经联通了，就什么也不做
        if (pid == qid){
            return;
        }
        //将p的分量重新命名为q的分量
        for (int i = 0; i < id.length; i++) {
            if (find(i) == pid){
                id[i] = qid;
            }
        }
        //每次union以后，联通分量减一
        count--;
    }
}
