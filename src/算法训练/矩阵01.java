package À„∑®—µ¡∑;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2019/12/7 16:01
 */
public class æÿ’Û01 {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = getNum(i, j, matrix);
                }
            }
        }
        return matrix;
    }

    public static int getNum(int x, int y, int[][] matrix) {
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][y] == 0) {
                if (Math.abs(i - x) < minNum) {
                    minNum = Math.abs(i - x);
                }
            } else if (matrix[i][y] > 1) {
                if (matrix[i][y] + 1 < minNum) {
                    minNum = matrix[i][y] + 1;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[x][i] == 0) {
                if (Math.abs(i - y) < minNum) {
                    minNum = Math.abs(i - y);
                }
            } else if (matrix[x][i] > 1) {
                if (matrix[x][i] + 1 < minNum) {
                    minNum = matrix[x][i] + 1;
                }
            }
        }
        return minNum;
    }
}
