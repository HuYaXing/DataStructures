package 玩转算法面试.时间复杂度;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/6 10:52
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            int n = (int) Math.pow(10, i);
            System.out.println(n+"------");
            long startTime = System.currentTimeMillis();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(j);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(i + ":::");
            System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        }
    }

}
