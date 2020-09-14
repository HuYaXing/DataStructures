package leetcode����.����.sf9_04;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/7 ����8:29
 */
public class ������ʽƥ�� {

    public boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //�ֳɿ�����ͷǿ���������
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //�ǿ������Ϊ������� * �� ��*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //���� * �ˣ���Ϊ���Ͳ����������
                        //����
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //��
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

}
