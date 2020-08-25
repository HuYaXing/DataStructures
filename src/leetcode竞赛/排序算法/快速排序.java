package leetcode竞赛.排序算法;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/8/15 9:34
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] array = {9, 5, 6, 3, 5, 0, 2};
        System.out.println(Arrays.toString(QuickSort(array, 0, array.length - 1)));
//        while (true) {
//            System.out.println((int) (Math.random() * 5));
//        }
    }

    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length == 0 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            QuickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            QuickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        swap(array, pivot, end);
        int smallIndex = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, smallIndex, i);
                }
            }
        }
        return smallIndex;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
