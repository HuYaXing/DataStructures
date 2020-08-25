package leetcode¾ºÈü.ÅÅĞòËã·¨;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/8/13 9:26
 */
public class Ã°ÅİÅÅĞò {

    public static void main(String[] args) {
        int[] array = {9, 5, 6, 3, 5, 0, 2};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
