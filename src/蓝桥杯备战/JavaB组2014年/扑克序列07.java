package 蓝桥杯备战.JavaB组2014年;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/5/21 16:36
 */
public class 扑克序列07 {

    static Set<String> res = new HashSet<>();
    static boolean[] used;

    public static void main(String[] args) {
        //全排列
        String[] arr = {"A", "A", "2", "2", "3", "3", "4", "4"};
        used = new boolean[arr.length];

        f(arr, 0, new StringBuilder());
        System.out.println(res);
    }


    private static void f(String[] arr, int index, StringBuilder path) {
        if (index == arr.length) {
            if (is(path.toString())) {
                res.add(path.toString());
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                path.append(arr[i]);
                used[i] = true;
                f(arr, index + 1, path);
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }

    static boolean is(String s) {
        int indexA = s.indexOf("A");
        if (indexA + 2 >= s.length() || s.charAt(indexA + 2) != 'A') {
            return false;
        }
        int index2 = s.indexOf("2");
        if (index2 + 3 >= s.length() || s.charAt(index2 + 3) != '2') {
            return false;
        }
        int index3 = s.indexOf("3");
        if (index3 + 4 >= s.length() || s.charAt(index3 + 4) != '3') {
            return false;
        }
        int index4 = s.indexOf("4");
        if (index4 + 5 >= s.length() || s.charAt(index4 + 5) != '4') {
            return false;
        }
        return true;
    }
}

