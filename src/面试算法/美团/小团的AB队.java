package 面试算法.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/22 17:41
 */
public class 小团的AB队 {

//    4 4
//  5 6 4 2 3 8 1 7
    //AAAABBBB
    static boolean[] memo;
    static int len;
    static int sums;
    static List<Integer> ans;
    static int max;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        len = x + y;
        max = Math.max(x, y);
        int[] nums = new int[len];
        sums = 0;
        for (int i = 0; i < x + y; i++) {
            nums[i] = sc.nextInt();
            sums += nums[i];
        }
        memo = new boolean[len];

        for (int i = 0; i < len; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            memo[i] = true;
            f(nums, list, nums[i]);
            memo[i] = false;
        }

        StringBuilder sb = new StringBuilder();

    }

    private static void f(int[] nums, List<Integer> list, int num) {
        if (list.size() == max) {
            if (Math.abs(num - sums) < res) {
                ans = new ArrayList<>(list);
            }
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!memo[i]) {
                list.add(i);
                memo[i] = true;
                f(nums, list, num + nums[i]);
                memo[i] = false;
            }
        }
    }

}
