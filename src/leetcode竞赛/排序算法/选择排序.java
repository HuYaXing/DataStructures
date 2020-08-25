package leetcodeæ∫»¸.≈≈–ÚÀ„∑®;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/8/13 9:30
 */
public class —°‘Ò≈≈–Ú {

    public static void main(String[] args) {
        int[] array = {9, 5, 6, 3, 5, 0, 2};
        System.out.println(Arrays.toString(selectionSort(array)));
    }

    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }

}
