package �����㷨.�ѹ�;

/**
 * @Author HYStar
 * @Date 2020/9/5 22:32
 */
public class ����Խ���Ԫ�صĺ� {

    public static void main(String[] args) {
        ����Խ���Ԫ�صĺ� main = new ����Խ���Ԫ�صĺ�();
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
