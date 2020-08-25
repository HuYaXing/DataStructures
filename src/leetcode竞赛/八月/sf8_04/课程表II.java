package leetcode竞赛.八月.sf8_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author HYStar
 * @Date 2020/8/4 23:25
 */
public class 课程表II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] cp : prerequisites) {
            in[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0){
                queue.add(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()){
            int pre = queue.poll();
            res[index++] = pre;
            numCourses--;
            for (int cur : adj.get(pre)) {
                if (--in[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        if (numCourses == 0){
            return res;
        }else {
            return new int[0];
        }
    }

}
