package À¶ÇÅ±­±¸Õ½.JavaB×é2014Äê;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/22 10:58
 */
public class ¾ØÕó·­Ó²±Ò10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                for (int i = 1; i <= n; i++) {
                    if (i * x > n) {
                        break;
                    }
                    for (int j = 1; j <= m; j++) {
                        if (j * y > m) {
                            break;
                        }
                        arr[i * x - 1][j * y - 1] ^= 1;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
