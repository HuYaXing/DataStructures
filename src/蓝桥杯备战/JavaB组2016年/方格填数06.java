package 蓝桥杯备战.JavaB组2016年;

/**
 * @Author HYStar
 * @Date 2020/5/27 10:48
 */
public class 方格填数06 {

    static int res = 0;

    public static void main(String[] args) {
        Integer[][] a = new Integer[3][4];

        f(a, 0, 0, 1);
        System.out.println(res);
    }

    static int[][] memo = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    static boolean[] flag = new boolean[10];

    private static void f(Integer[][] a, int k, int x, int y) {
        if (k == 10) {
            res++;
            return;
        }

        for (int l = 0; l <= 9; l++) {
            if (check(a, x, y, l) && !flag[l]) {
                a[x][y] = l;
                flag[l] = true;
                f(a, k + 1, x + (y + 1) / 4, (y + 1) % 4);
                flag[l] = false;
            }
        }
    }

    private static boolean check(Integer[][] a, int x, int y, int l) {
        for (int i = 0; i < memo.length; i++) {
            int newX = x + memo[i][0];
            int newY = y + memo[i][1];
            if (newX >= 0 && newY >= 0 && newX < 3 && newY < 4) {
                if (a[newX][newY] != null && Math.abs(a[newX][newY] - l) <= 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
