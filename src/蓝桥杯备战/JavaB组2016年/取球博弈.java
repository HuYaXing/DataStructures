package À¶ÇÅ±­±¸Õ½.JavaB×é2016Äê;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/28 19:16
 */
public class È¡Çò²©ÞÄ {
    static int[] n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = new int[3];
        n[0] = scanner.nextInt();
        n[1] = scanner.nextInt();
        n[2] = scanner.nextInt();
        Arrays.sort(n);
        for (int i = 0; i < 5; i++) {
            int num = scanner.nextInt();
            char res = f(num, 0, 0);
            System.out.print(res + " ");
        }
        System.out.println();
    }

    private static char f(int num, int me, int you) {

        if (num < n[0]) {
            if ((me & 1) == 1 && (you & 1) == 0) {
                return '+';
            }else if ((me & 1) == 0 && (you & 1) == 1){
                return '-';
            }else {
                return '0';
            }
        }

        boolean ping = false;
        for (int i = 0; i < 3; i++) {
            if (num >= n[i]) {
                //²©ÞÄµÝ¹é
                char res = f(num - n[i], you, me + n[i]);
                if (res == '-') {
                    return '+';
                }
                if (res == '0') {
                    ping = true;
                }
            }
        }
        if (ping) {
            return '0';
        }else {
            return '-';
        }
    }

}
