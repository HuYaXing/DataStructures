package 蓝桥杯备战.JavaB组2013年;

/**
 * @Author HYStar
 * @Date 2020/5/11 10:44
 */
public class 振兴中华03 {

    private static int res = 0;

    public static void main(String[] args) {
        String[][] array = {
                {"从", "我", "做", "起", "振"},
                {"我", "做", "起", "振", "兴"},
                {"做", "起", "振", "兴", "中"},
                {"起", "振", "兴", "中", "华"},
        };
        dfs(array, 0, 0, "从");
        System.out.println(res);
    }

    private static void dfs(String[][] array, int x, int y, String path) {
        if (path.length() == 8) {
            if ("从我做起振兴中华".equals(path)) {
                res++;
            }
            return;
        }

        //向右移动
        int rightX = x;
        int rightY = y + 1;

        if (rightX < array.length && rightY < array[0].length) {
            dfs(array, rightX, rightY, path + array[rightX][rightY]);
        }

        //向下移动
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
