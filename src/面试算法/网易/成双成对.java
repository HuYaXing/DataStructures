package 面试算法.网易;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/12 15:44
 */
public class 成双成对 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] pos = new int[1 << 6];
        int res = 0, status = 0;
        Arrays.fill(pos, -1);
        pos[0] = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a') {
                status ^= 1 << 0;
            } else if (ch == 'b') {
                status ^= 1 << 1;
            } else if (ch == 'c') {
                status ^= 1 << 2;
            } else if (ch == 'x') {
                status ^= 1 << 3;
            } else if (ch == 'y') {
                status ^= 1 << 4;
            } else if (ch == 'z') {
                status ^= 1 << 5;
            }
            if (pos[status] >= 0) {
                res = Math.max(res, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        System.out.println(res);
    }

}
