package leetcode¾ºÈü.°ËÔÂ.sf8_15;

/**
 * @Author HYStar
 * @Date 2020/8/15 19:04
 */
public class Main10 {

    static int ans = 0;
    public static void main(String[] args) {
        String s = "sa";
        s.trim();
        int[][] arr = {{1, 2}, {3, 4}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                f(arr, i, j);
            }
        }
        System.out.println(ans);
    }
    private static void f(int[][] arr, int x, int y) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (x != i && y != j) {
                    ans = Math.max(ans, arr[x][y] * arr[i][j]);
                }
            }
        }
    }

}
