package ��ת�㷨����.���鼯;

/**
 * �˰汾��������Ĳ��鼯�汾�������������Ż���
 * 1.���Ⱥϲ���2���汾��
 * 2.·��ѹ����2���汾��
 * ����˼���ǡ�����Ԫ�����������ĸ��ڵ����Ԫ
 * ʹ��parent���飬parent[i]��������Ϊi�Ľڵ�ĸ��׽ڵ������
 *
 * @author ��huyaxing
 * @date ��Created in 2020/9/14 ����4:31
 */
public class UnionFind2 implements IUnionFind {

    /**
     * ��i��Ԫ�أ�������ĸ�Ԫ������
     */
    private int[] parent;

    /**
     * ��ͨ����������
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
        return "���鼯�ĵ� 2 ���汾������ parent ���飬quick-union";
    }

    @Override
    public int find(int p) {
        //���������ҵ����ڵ�,������Ǹ��ڵ�
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

        // ��� p �� q �Ѿ�����ͬ�ķ���֮�У���ʲô������
        if (pRoot == qRoot){
            return;
        }
        //������Ҳ���ԣ������汾�����һ�������Ż�
        parent[pRoot] = qRoot;
        count--;
    }
}
