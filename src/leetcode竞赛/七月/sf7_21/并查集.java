package leetcode����.����.sf7_21;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/7/21 22:00
 */
public class ���鼯 {

    public int findCircleNum() {
        Scanner scanner = new Scanner(System.in);
        //��ľ����
        int n = scanner.nextInt();
        //������λ��
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
    //��¼��ͨ����
    private int count;
    //�ڵ�x�Ľڵ���parent[x]
    private int[] parent;
    // ����һ�������¼���ġ�������
    private int[] size;

    /**
     * ���췽����nΪͼ�Ľڵ�����
     */
    public UF(int n){
        //һ��ʼ������ͨ
        this.count = n;
        //���ڵ�ָ���ʼָ���Լ�
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

        // С���ӵ��������棬��ƽ��
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
     * ����ĳ���ڵ�ĸ��ڵ�
     * @param x
     * @return
     */
    private int find(int x){
        //���ڵ��parent[x] = x;
        while (parent[x] != x){
            // ����·��ѹ��
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /* ���ص�ǰ����ͨ�������� */
    public int count() {
        return count;
    }

}
