package ��ת�㷨����.�ݹ������;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/29 11:07
 */
public class ����ܺ�III {

    public static void main(String[] args) {
        ����ܺ�III main = new ����ܺ�III();
        System.out.println(main.combinationSum3(3, 9));
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0 || k > n) {
            return res;
        }
        generatePermutation(k, n, 1, new LinkedList<>());
        return res;
    }

    public void generatePermutation(int k, int n, int start, LinkedList<Integer> path) {
        if (n == 0 && path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.addLast(i);
            generatePermutation(k, n - i, i + 1, path);
            path.removeLast();
        }
    }

}
