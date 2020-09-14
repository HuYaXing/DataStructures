package 面试算法.搜狗;

/**
 * @Author HYStar
 * @Date 2020/9/5 22:32
 */
public class 矩阵对角线元素的和 {

    public static void main(String[] args) {
        矩阵对角线元素的和 main = new 矩阵对角线元素的和();
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(main.diagonalSum(mat));
    }

    public int diagonalSum(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == j || i + j == mat.length - 1) {
                    res += mat[i][j];
                    mat[i][j] = 0;
                }
            }
        }
        return res;
    }

}
