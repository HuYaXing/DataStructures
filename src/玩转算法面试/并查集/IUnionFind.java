package 玩转算法面试.并查集;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/14 下午4:15
 */
public interface IUnionFind {

    /**
     * 并查集的版本名称
     *
     * @return
     */
    String versionName();

    /**
     * p(0到N-1)所在分量的标示符
     *
     * @param p
     * @return
     */
    int find(int p);

    /**
     * 如果p和q存在于同一分量中则返回true
     *
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 在p和q之间添加一条链接
     * @param p
     * @param q
     */
    void union(int p, int q);

}
