package leetcode����.����.sf7_23;

/**
 * @Author HYStar
 * @Date 2020/7/23 22:29
 */
public class ��ά�����еĲ��� {

    public static void main(String[] args) {
        ��ά�����еĲ��� main = new ��ά�����еĲ���();

    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0){
            int num = matrix[row][column];
            if (num == target){
                return true;
            }else if (num < target){
                row++;
            }else {
                column--;
            }
        }
        return false;
    }

}
