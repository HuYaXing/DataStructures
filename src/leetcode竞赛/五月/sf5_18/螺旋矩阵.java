package leetcode竞赛.五月.sf5_18;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/5/18 19:23
 */
public class 螺旋矩阵 {

    public static void main(String[] args) {
        int[][] matrix = {};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int width = matrix.length;

        if (width == 0) {
            return res;
        }

        int length = matrix[0].length;
        if (width == 1) {
            for (int i = 0; i < length; i++) {
                res.add(matrix[0][i]);
            }
            return res;
        }
        if (length == 1) {
            for (int i = 0; i < width; i++) {
                res.add(matrix[i][0]);
            }
            return res;
        }
        boolean[][] memo = new boolean[width][length];

        //右、下、左、上
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;

        int x = 0;
        int y = 0;

        while (!memo[x][y]) {
            memo[x][y] = true;
            res.add(matrix[x][y]);
            int newX = x + direction[index % 4][0];
            int newY = y + direction[index % 4][1];
            if (newX < width && newX >= 0 &&
                    newY < length && newY >= 0 &&
                    !memo[newX][newY]) {
                x = newX;
                y = newY;
            } else {
                index++;
                x = x + direction[index % 4][0];
                y = y + direction[index % 4][1];
            }
        }
        return res;
    }

}
