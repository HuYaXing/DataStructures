package 面试算法.京东;

import javafx.util.Pair;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/8/27 18:54
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        TreeMap<Integer, LinkedList<Integer>> treeMap = new TreeMap<>();

//        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int index = sc.nextInt();
                LinkedList<Integer> linkedList = new LinkedList<>();
                if (treeMap.containsKey(index)) {
                    linkedList = treeMap.get(index);
                }
                linkedList.add(sc.nextInt());
                treeMap.put(index, linkedList);
            } else if (op == 2) {

//                list.remove(sc.nextInt() - 1);
            } else {
//                for (Integer num : list) {
//                    System.out.print(num + " ");
//                }
            }
        }
    }
}
