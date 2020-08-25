package 蓝桥杯备战.JavaB组2015年;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/5/24 17:02
 */
public class 牌型种数07 {

    public static void main(String[] args) {

//        for (int i = 0; i <= 4; i++) {
//            for (int j = 0; j <= 4; j++) {
//                for (int k = 0; k <= 4; k++) {
//                    for (int l = 0; l <= 4; l++) {
//                        for (int m = 0; m <= 4; m++) {
//                            for (int n = 0; n <= 4; n++) {
//                                for (int o = 0; o <= 4; o++) {
//                                    for (int p = 0; p <= 4; p++) {
//                                        for (int q = 0; q <= 4; q++) {
//                                            for (int r = 0; r <= 4; r++) {
//                                                for (int s = 0; s <= 4; s++) {
//                                                    for (int t = 0; t <= 4; t++) {
//                                                        for (int u = 0; u <= 4; u++) {
//                                                            if (i + j + k + l + m + n + o + p + q + r + s + t + u == 13) {
//                                                                res++;
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }

//        f(0, new HashMap<Integer, Integer>());
//        f1(0, 0);
        System.out.println(res);
    }

    static int res;

    //超时
    private static void f(int num, HashMap<Integer, Integer> path) {
        if (num == 13) {
            res++;
            System.out.println(res);
            return;
        }
        for (int i = 1; i <= 13; i++) {
            if (path.getOrDefault(i, 0) < 4) {
                path.put(i, path.getOrDefault(i, 0) + 1);
                f(num + 1, path);
                path.put(i, path.get(i) - 1);
            }
        }
    }

    private static void f1(int k, int cot) {
        if (cot > 13 || k > 13) {
            return;
        }
        if (k == 13 && cot == 13){
            res++;
            return;
        }
        for (int i = 0; i < 5; i++) {
            f1(k + 1, cot + i);
        }
    }
}
