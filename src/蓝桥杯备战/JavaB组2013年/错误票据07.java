package 蓝桥杯备战.JavaB组2013年;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/5/12 8:09
 */
public class 错误票据07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            String[] s = str.split(" ");
            for (int j = 0; j < s.length; j++) {
                int key = Integer.parseInt(s[j]);
                min = Math.min(key, min);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int a = 0, b = 0;
        int res = 0;
        for (int i = min; i <= min + map.size(); i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    a = i;
                    res++;
                }
            } else {
                b = i;
                res++;
            }
            if (res == 2){
                break;
            }
        }
        System.out.println(b + " " + a);
    }

}
