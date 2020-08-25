package ���ű���ս.JavaB��2013��;

/**
 * @Author HYStar
 * @Date 2020/5/11 10:44
 */
public class �����л�03 {

    private static int res = 0;

    public static void main(String[] args) {
        String[][] array = {
                {"��", "��", "��", "��", "��"},
                {"��", "��", "��", "��", "��"},
                {"��", "��", "��", "��", "��"},
                {"��", "��", "��", "��", "��"},
        };
        dfs(array, 0, 0, "��");
        System.out.println(res);
    }

    private static void dfs(String[][] array, int x, int y, String path) {
        if (path.length() == 8) {
            if ("�������������л�".equals(path)) {
                res++;
            }
            return;
        }

        //�����ƶ�
        int rightX = x;
        int rightY = y + 1;

        if (rightX < array.length && rightY < array[0].length) {
            dfs(array, rightX, rightY, path + array[rightX][rightY]);
        }

        //�����ƶ�
        int downX = x + 1;
        int downY = y;
        if (downX < array.length && downY < array[0].length) {
            dfs(array, downX, downY, path + array[downX][downY]);
        }
    }

    private static int f(int i, int j) {
        if (i == 3 || j == 4) {
            return 1;
        }
        return f(i + 1, j) + f(i, j + 1);
    }

}
