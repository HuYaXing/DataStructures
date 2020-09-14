package ÃæÊÔËã·¨.ÍøÒ×;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/12 15:08
 */
public class ÕªÓ£ÌÒ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n + 1][2];
        for (int i = 0; i < m; i++) {
            int id = sc.nextInt();
            String str = sc.next();
            int child = sc.nextInt();
            if ("left".equals(str)) {
                nums[id][0] = child;
            } else {
                nums[id][1] = child;
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count(nums[i]) == 2 && count(nums[nums[i][0]]) == 0 && count(nums[nums[i][1]]) == 0) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static int count(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                count++;
            }
        }
        return count;
    }

}
