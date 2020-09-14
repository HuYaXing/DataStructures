package ��ת�㷨����.���鼯;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/14 ����4:15
 */
public interface IUnionFind {

    /**
     * ���鼯�İ汾����
     *
     * @return
     */
    String versionName();

    /**
     * p(0��N-1)���ڷ����ı�ʾ��
     *
     * @param p
     * @return
     */
    int find(int p);

    /**
     * ���p��q������ͬһ�������򷵻�true
     *
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * ��p��q֮�����һ������
     * @param p
     * @param q
     */
    void union(int p, int q);

}
