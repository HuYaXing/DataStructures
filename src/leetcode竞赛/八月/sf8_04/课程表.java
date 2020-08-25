package leetcode竞赛.八月.sf8_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author HYStar
 * @Date 2020/8/4 8:37
 */
public class 课程表 {

    public static void main(String[] args) {
        int[][] prerequisites = {{3, 4}, {4, 3}};
        课程表 main = new 课程表();
        main.canFinish(2, prerequisites);
    }

    /*广度优先遍历 入度表*/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] cp : prerequisites) {
            //每个元素的入度
            indegrees[cp[0]]++;
            //每个元素的指向节点
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            //先将入度为0的节点加入
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                if (--indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

}
