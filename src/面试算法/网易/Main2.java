package ÃæÊÔËã·¨.ÍøÒ×;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/8 15:10
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            vis[num] = true;
            q.offer(num);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (vis[i]) {
                continue;
            }
            while (!q.isEmpty() && q.peek() < i) {
                ans.append(q.poll() + " ");
            }
            ans.append(i + " ");
        }
        while (!q.isEmpty()) {
            ans.append(q.poll() + " ");
        }
        System.out.print(ans.toString().substring(0, ans.length() - 1));
    }

}
