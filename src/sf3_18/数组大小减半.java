package sf3_18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/3/18 16:52
 */
public class 数组大小减半 {

    public static void main(String[] args) {
        boolean b = true ? false : true == true ? false : true;
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};

        System.out.println(minSetSize(arr));
    }

    public static int minSetSize(int[] arr) {
        int len = arr.length, res = 0, limit = len >> 1;
        HashMap<Integer, Integer> map = new HashMap<>(len);
        for (int num : arr) {
            //key不存在就相当于put，存在就加一
            map.merge(num, 1, (o_value, n_value) -> o_value + n_value);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Comparator.comparingInt(item -> -item));

        System.out.println(map);
        System.out.println(list);

        for (int num : list) {
            ++res;
            if ((len -= num) <= limit) {
                return res;
            }
        }
        return -1;
    }

}
