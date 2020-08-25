package 蓝桥杯备战.JavaB组2016年;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/5/29 9:44
 */
public class 压缩变换10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (map.containsKey(num)) {
                System.out.print(check(map.get(num), map) + " ");
            } else {
                System.out.print(-1 * num + " ");
            }
            map.put(num, i);
        }
    }

    private static int check(int num, Map<Integer, Integer> map) {
        Set<Integer> set = map.keySet();

        int res = 0;
        for (Integer s : set) {
            if (map.get(s) > num){
                res++;
            }
        }

        return res;
    }

}
