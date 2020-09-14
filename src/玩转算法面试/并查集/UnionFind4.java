package ��ת�㷨����.���鼯;

/**
 * ʵ����ʹ��size���鲢����������������Ԫ����಻�ܴ���߶����
 * ������������rank���飬rank[i]�����Ե�i��Ԫ��Ϊ�������ĸ߶�
 *
 * @author ��huyaxing
 * @date ��Created in 2020/9/14 ����5:06
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
        return "���鼯�ĵ� 4 ���汾������ parent ���飬quick-union������ rank";
    }

    @Override
    public int find(int p) {
//        while (p != parent[p]) {
//            p = parent[p];
//        }
//        return p;

        //·��ѹ��
//        while (p != parent[p]) {
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }
//        return p;
        //���ӳ��׵�ѹ��
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
        // ��һ������� 3 �治ͬ�ĵط�
        if (parent[pRoot] > parent[qRoot]) {
            parent[qRoot] = pRoot;
        } else if (parent[pRoot] < parent[qRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
        // ÿ�� union �Ժ���ͨ������ 1
        count--;
    }
}
