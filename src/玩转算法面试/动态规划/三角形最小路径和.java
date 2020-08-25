package 玩转算法面试.动态规划;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/1 14:27
 */
public class 三角形最小路径和 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        三角形最小路径和 main = new 三角形最小路径和();
        List<List<Integer>> triangle = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            String str = scanner.nextLine();
            for (int j = 0; j < str.length(); j++) {
                temp.add(str.charAt(j) - '0');
            }
            triangle.add(temp);
        }
        System.out.println(triangle);
        System.out.println(main.minimumTotal1(triangle));
    }


    public int minimumTotal1(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            //第i行有i+1个数字
            for (int i = 0; i <= level; i++) {
                minlen[i] = Math.min(minlen[i], minlen[i + 1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }

    int row;
    Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new Integer[row][row];
        return recursive(triangle, 0, 0);
    }

    private int recursive(List<List<Integer>> triangle, int index, int x) {
        if (index == row - 1) {
            return triangle.get(index).get(x);
        }
        if (memo[index][x] != null) {
            return memo[index][x];
        }
        return memo[index][x] = triangle.get(index).get(x) +
                Math.min(recursive(triangle, index + 1, x),
                        recursive(triangle, index + 1, x + 1));
    }

}
