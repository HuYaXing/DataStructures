package leetcode����.����;

import java.util.List;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/8/31 ����3:53
 */
public class Կ�׺ͷ��� {
    boolean[] vis;
    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    private void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }

}
