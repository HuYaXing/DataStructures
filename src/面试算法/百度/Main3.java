package 面试算法.百度;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/3 20:35
 */
public class Main3 {

    static int res = 0;

    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        dfs(n, m, new ArrayList<>(), 0);
//        System.out.println(res);
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });
        queue.add(9);
        queue.add(10);
        queue.add(1);
        queue.add(99);
        System.out.println(queue);

    }

    private static void dfs(int n, int m, ArrayList<Integer> path, int nums) {
        if (nums >= n) {
            if (nums == n) {
                res++;
            }
            return;
        }

        for (int i = 1; i <= m; i++) {
            int num1 = 0;
            int num2 = 0;
            int size = path.size();
            if (size == 1) {
                num1 = path.get(0);
            } else if (size >= 2) {
                num1 = path.get(size - 1);
                num2 = path.get(size - 2);
            }
            if (i != num1 && i != num2) {
                path.add(i);
                dfs(n, m, path, nums + i);
                path.remove(path.size() - 1);
            }
        }
    }

}
