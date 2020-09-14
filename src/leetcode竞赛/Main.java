package leetcode¾ºÈü;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int res = -1;
    static boolean[] meme;
    static boolean flag = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int[] nums = new int[n];
        meme = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = B % 10;
            B /= 10;
        }
        Arrays.sort(nums);
        dfs(nums, A, new ArrayList<>());
        System.out.println(res);
    }

    private static void dfs(int[] nums, int A, ArrayList<Integer> path) {
        if (flag) {
            if (path.size() == nums.length) {
                int B = 0;
                int index = 1;
                for (int i = path.size() - 1; i >= 0; i--) {
                    B += path.get(i) * index;
                    index *= 10;
                }
                if (B > A) {
                    flag = false;
                    res = B;
                }
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!meme[i]) {
                    meme[i] = true;
                    path.add(nums[i]);
                    dfs(nums, A, path);
                    path.remove(path.size() - 1);
                    meme[i] = false;
                }
            }
        }
    }

}
