package ����;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/8 ����1:58
 */
public class ��� {

    public static void main(String[] args) {
        ��� main = new ���();
        System.out.println(main.combine(4, 2));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return res;
        }
        dfs(n, k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int k, int index, ArrayList<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

}
