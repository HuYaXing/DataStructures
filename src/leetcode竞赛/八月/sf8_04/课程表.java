package leetcode����.����.sf8_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author HYStar
 * @Date 2020/8/4 8:37
 */
public class �γ̱� {

    public static void main(String[] args) {
        int[][] prerequisites = {{3, 4}, {4, 3}};
        �γ̱� main = new �γ̱�();
        main.canFinish(2, prerequisites);
    }

    /*������ȱ��� ��ȱ�*/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] cp : prerequisites) {
            //ÿ��Ԫ�ص����
            indegrees[cp[0]]++;
            //ÿ��Ԫ�ص�ָ��ڵ�
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            //�Ƚ����Ϊ0�Ľڵ����
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
