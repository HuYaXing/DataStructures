package leetcode竞赛.排序算法;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/8/15 10:57
 */
public class 计数排序 {

    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        Util.print(randomArr);
        CountingSort(randomArr);
        Util.print(randomArr);
    }

    public static int[] CountingSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
        return array;
    }

}
