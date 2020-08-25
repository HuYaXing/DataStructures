package 蓝桥杯备战.JavaB组2017年;

import java.util.Arrays;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/5/29 11:26
 */
public class 魔方状态04 {

    public static void main(String[] args) {
        solve();
    }

    static Set<String> all_state;
    static char[][][] q = new char[8][7][4000000];
    static char[][] start = {
            "oybbgb".toCharArray(),
            "oygbbb".toCharArray(),
            "bygbby".toCharArray(),
            "bybbgy".toCharArray(),
            "obbogb".toCharArray(),
            "obgobb".toCharArray(),
            "bbgoby".toCharArray(),
            "bbbogy".toCharArray()
    };
    static int front, tail, ans;

    private static void solve() {
        front = 0;
        tail = 1;
        all_state.add(to_string(start));
        memcpy(q[front], start);
        while (front < tail) {
            memcpy(q[tail], q[front]);
            u(q[tail]);
            if (try_insert(q[tail])) {
                tail++;
            }
            memcpy(q[tail], q[front]);
            r(q[tail]);
            if (try_insert(q[tail])) {
                tail++;
            }
            memcpy(q[tail], q[front]);
            f(q[tail]);
            if (try_insert(q[tail])) {
                tail++;
            }
            front++;
        }
        System.out.println(front);
    }

    private static void memcpy(char[][] k, char[][] s) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                k[i][j] = s[i][j];
            }
        }
    }

    private static boolean try_insert(char[][] s) {
        char[][] k = new char[8][6];
        memcpy(k, s);
        for (int i = 0; i < 4; i++) {
            fwhole(k);
            for (int j = 0; j < 4; j++) {
                uwhole(k);
                for (int l = 0; l < 4; l++) {
                    rwhole(k);
                    if (all_state.contains(to_string(k))) {
                        return false;
                    }
                }
            }
        }
        all_state.add(to_string(k));
        return true;
    }

    private static void rwhole(char[][] s) {
        r(s);
        rcell(s[0]);
        rcell(s[3]);
        rcell(s[4]);
        rcell(s[7]);

        swap(s, 3, 7);
        swap(s, 0, 3);
        swap(s, 4, 0);
    }

    private static void fwhole(char[][] s) {
        f(s);
        fcell(s[2]);
        fcell(s[6]);
        fcell(s[7]);
        fcell(s[3]);

        swap(s, 2, 6);
        swap(s, 3, 2);
        swap(s, 7, 3);
    }

    private static void uwhole(char[][] s) {
        u(s);
        ucell(s[0]);
        ucell(s[3]);
        ucell(s[4]);
        ucell(s[7]);

        swap(s, 3, 7);
        swap(s, 0, 3);
        swap(s, 4, 0);
    }

    private static void u(char[][] s) {
        ucell(s[0]);
        ucell(s[1]);
        ucell(s[2]);
        ucell(s[3]);

        swap(s, 1, 0);
        swap(s, 2, 1);
        swap(s, 3, 2);
    }

    private static void ucell(char[] a) {
        swap(a, 0, 2);
        swap(a, 2, 5);
        swap(a, 5, 4);
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void swap(char[][] a, int i, int j) {
        char[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void r(char[][] s) {
        rcell(s[1]);
        rcell(s[2]);
        rcell(s[6]);
        rcell(s[5]);

        swap(s, 2, 1);
        swap(s, 5, 1);
        swap(s, 6, 5);
    }

    private static void rcell(char[] a) {
        swap(a, 1, 0);
        swap(a, 0, 3);
        swap(a, 3, 5);
    }

    private static void f(char[][] s) {
        fcell(s[0]);
        fcell(s[1]);
        fcell(s[4]);
        fcell(s[5]);

        swap(s, 1, 5);
        swap(s, 0, 1);
        swap(s, 4, 0);
    }

    private static void fcell(char[] a) {
        swap(a, 2, 1);
        swap(a, 1, 4);
        swap(a, 4, 3);
    }

    private static String to_string(char[][] a) {
        String ans = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                ans += a[i][j];
            }
        }
        return ans;
    }

}
