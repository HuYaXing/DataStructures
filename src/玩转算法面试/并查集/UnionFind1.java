package ��ת�㷨����.���鼯;

import ��ת�㷨����.���鼯.IUnionFind;

/**
 * ����id��quick-find˼·���������ã���Ϊ�˽�
 * find�����ǳ���Ч������union������Ҫ������������
 *
 * @author ��huyaxing
 * @date ��Created in 2020/9/14 ����4:18
 */
public class UnionFind1 implements IUnionFind {

    /**
     * ����id
     */
    private int[] id;

    /**
     * ��ͨ����������
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
        return "���鼯�ĵ� 1 ���汾������ id ���飬quick-find";
    }

    /**
     * �Գ���ʱ�临�Ӷȣ����ط����ı�ʶ�����벢�鼯�Ĺ�ģ���޹صģ���һ���ܿ�
     * ������ǳ�����汾�Ĳ��鼯�� quick-find
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

        //����Ѿ���ͨ�ˣ���ʲôҲ����
        if (pid == qid){
            return;
        }
        //��p�ķ�����������Ϊq�ķ���
        for (int i = 0; i < id.length; i++) {
            if (find(i) == pid){
                id[i] = qid;
            }
        }
        //ÿ��union�Ժ���ͨ������һ
        count--;
    }
}
