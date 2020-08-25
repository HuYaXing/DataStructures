package leetcode¾ºÈü.ÅÅĞòËã·¨;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/8/13 9:36
 */
public class Ï£¶ûÅÅĞò {

    public static void main(String[] args) {
        int[] array = {9, 5, 6, 3, 5, 0, 2};
        System.out.println(Arrays.toString(shellSort(array)));
    }

    public static int[] shellSort(int[] array) {
        int len = array.length;
        int gap = len / 2;
        int temp;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int perIndex = i - gap;
                while (perIndex >= 0 && array[perIndex] > temp) {
                    array[perIndex + gap] = array[perIndex];
                    perIndex -= gap;
                }
                array[perIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

}
