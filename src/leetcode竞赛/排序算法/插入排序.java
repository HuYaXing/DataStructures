package leetcode¾ºÈü.ÅÅĞòËã·¨;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/8/13 9:31
 */
public class ²åÈëÅÅĞò {

    public static void main(String[] args) {
        int[] array = {9, 5, 6, 3, 5, 0, 2};
        System.out.println(Arrays.toString(insertionSort(array)));
    }

    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int cur;
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            cur = array[i + 1];
            while (index >= 0 && array[index] > cur){
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = cur;
        }
        return array;
    }

}
