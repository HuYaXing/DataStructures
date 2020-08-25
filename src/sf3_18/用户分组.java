package sf3_18;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/3/19 10:29
 */
public class 用户分组 {

    public static void main(String[] args) {
        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(groupSizes));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] flag = new boolean[len];
        for (int i = 0; i < len; i++) {
            int count = 0;

            List<Integer> list = new ArrayList<>();
            for (int j = i; j < len; j++) {
                if (!flag[j] && (groupSizes[i] == groupSizes[j])) {
                    list.add(j);
                    count += 1;
                    flag[j] = true;
                    if (count == groupSizes[i]) {
                        break;
                    }
                }
            }
            if (list.size() > 0) {
                lists.add(list);
            }
        }
        return lists;
    }
}
