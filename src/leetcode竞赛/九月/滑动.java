package leetcode竞赛.九月;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/18 下午3:05
 */
public class 滑动 {

    public static void main(String[] args) {
        int[][] init_state = new int[][]{
                {2, 8, 3},
                {1, 0, 4},
                {7, 6, 5}
        };
        int[][] final_state = new int[][]{
                {1, 2, 3},
                {8, 0, 4},
                {7, 6, 5}
        };
        滑动 main = new 滑动();
        System.out.println(main.minMoveStep(init_state, final_state));
    }

    int[][] exchangeArray = new int[][]{
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4, 6},
            {1, 3, 5, 7},
            {2, 4, 8},
            {3, 7},
            {4, 6, 8},
            {5, 7}
    };

    public String exchangeString(String string, int src, int dis) {
        char[] chars = string.toCharArray();
        char temp = chars[dis];
        chars[dis] = chars[src];
        chars[src] = temp;
        return new String(chars);
    }

    public int minMoveStep(int[][] init_state, int[][] final_state) {
        char[] chars = new char[9];
        int index = 0;
        for (int[] row : init_state) {
            for (int ch : row) {
                chars[index++] = (char) (ch + '0');
            }
        }
        String start = new String(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < final_state.length; i++) {
            for (int j = 0; j < final_state[i].length; j++) {
                sb.append(final_state[i][j]);
            }
        }
        String target = sb.toString();
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(start);
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                }
                int position = cur.indexOf('0');
                int[] exchanges = exchangeArray[position];
                for (int next : exchanges) {
                    String s = exchangeString(cur, position, next);
                    if (!visited.contains(s)) {
                        q.offer(s);
                        visited.add(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }

}
