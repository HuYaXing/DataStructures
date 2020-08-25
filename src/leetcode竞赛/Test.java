package leetcode¾ºÈü;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.Executors;

/**
 * @Author HYStar
 * @Date 2020/8/13 23:09
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(a(1));
        System.out.println(a(3));
        System.out.println(a(7));
        System.out.println(a(14));
        System.out.println(a(951124));
//        System.out.println(1 | 0);
//        int res = 0;
//        for (int i = 1; i <= 1000; i++) {
//            String s = i + "";
//            if (s.contains("0")) {
//                res++;
//            }
//        }
//        System.out.println(res);
        System.out.println(Integer.toBinaryString(1 << 30));
    }

    private static int a(int tab) {
//        Executors.newScheduledThreadPool(25);
//        Arrays.sort();
        int n = tab - 1;
//        PriorityQueue
//        n |= n >> 1;
//        n |= n >> 2;
//        n |= n >> 4;
//        n |= n >> 8;
        n |= n >> 16;
        return n + 1;
    }

}
