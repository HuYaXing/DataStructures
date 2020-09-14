package ��ת�㷨����.���鼯;

/**
 * ���Ⱥϲ�1.0  ����size���Ż�  union-find �㷨��ʵ�֣���Ȩ quick-union �㷨��
 * Ϊ��ʹ������ƽ����Ⱦ�����С������size����
 * size[i] �Ķ����ǣ��Ե�i���ڵ�Ϊ���ļ���Ԫ�صĸ���
 * ��ʼ��size[i] = 1����sizeС�ĸ�������size��ĸ�����
 *
 * @author ��huyaxing
 * @date ��Created in 2020/9/14 ����4:46
 */
public class UnionFind3 implements IUnionFind {

    /**
     * �� i ��Ԫ�ش�����ĸ�Ԫ�ص�����
     */
    private int[] parent;

    /**
     * ��ͨ����������
     */
    private int count;

    /**
     * �Ե�ǰ����Ϊ��������������Ԫ�ص�����
     */
    private int[] size;

    public UnionFind3(int n) {
        this.count = n;
        this.size = new int[n];
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            //��ʼ����ʱ��ÿ��Ԫ��ֻ�������Լ���ֻ��һ��Ԫ��
            size[i] = 1;
        }
    }

    @Override
    public String versionName() {
        return "���鼯�ĵ� 3 ���汾������ parent ���飬quick-union������ size";
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

        // ��һ������� 2 �治ͬ�ĵط������ǲ���û�и��ݵذ�һ�����ĸ����ĸ����ָ����һ�����ĸ����
        // ���ǽ�С���ĸ�������ӵ������ĸ����
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
