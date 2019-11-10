package sparseArray;

/**
 * @Author HYStar
 * @Date 2019/11/6 16:41
 */
public class SparseArray {

    public static void main(String[] args) {
        //����һ����ά����  11 * 11
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;

        //���ԭʼ�Ķ�ά����
        System.out.println("ԭʼ�Ķ�ά����");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //����ά����תΪϡ�������˼·
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //����ϡ������
        int[][] sparseArr = new int[sum + 1][3];
        //��ϡ�����鸳ֵ
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //������ֵ����ϡ������
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("ϡ�����飺");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n\r", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        //ϡ������ָ���ԭ��������
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr[0].length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("ԭʼ�Ķ�ά����");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
