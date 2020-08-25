package 玩转算法面试.递归与回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/28 17:19
 */
public class 组合 {

    public static void main(String[] args) {
        组合 main = new 组合();
        System.out.println(main.combine(4, 2));
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        generatePermutation(n, k, 1, new LinkedList<>());
        return res;
    }

    public void generatePermutation(int n, int k, int start, LinkedList<Integer> path) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }
        //还有k - path.size()个空位，【i...n】中至少有k - path.size()个元素
        //i最多为n - (k - path.size()) + 1
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            generatePermutation(n, k, i + 1, path);
            path.removeLast();
        }
    }
}
