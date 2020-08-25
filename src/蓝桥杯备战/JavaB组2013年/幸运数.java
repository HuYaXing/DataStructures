package 蓝桥杯备战.JavaB组2013年;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/5/12 10:52
 */
public class 幸运数 {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 1;
        while (list.get(index) <= list.size()) {
            Iterator<Integer> iterator = list.iterator();
            int i = 1;
            int in = list.get(index);
            while (iterator.hasNext()) {
                Integer temp = iterator.next();
                if (i % in == 0) {
                    if (temp == in) {
                        index--;
                    }
                    iterator.remove();
                }
                i++;
            }
            index++;
        }

        int res = 0;
        for (Integer temp : list) {
            if (temp <= m || temp >= n) {
                res++;
            }
        }
        System.out.println(list);
        System.out.println(list.size() - res);
    }

}
