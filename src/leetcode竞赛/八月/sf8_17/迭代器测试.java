package leetcode¾ºÈü.°ËÔÂ.sf8_17;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/8/12 19:24
 */
public class µü´úÆ÷²âÊÔ {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6};
//        System.arraycopy(arr, 3, arr, 2, 3);
//        System.out.println(Arrays.toString(arr));
//        HashMap
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println("-----------------");
            int num = iterator.next();
            System.out.println(num);
//            iterator.remove();
            if (num == 2){
                list.remove(0);
                list.remove(1);
            }
        }

//        boolean b = list.remove(2);
//        boolean v = list.remove(new Integer(2));
//        boolean a = list.remove(new Integer(2));

        System.out.println(list);
    }

}
