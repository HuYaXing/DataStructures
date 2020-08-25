package leetcode竞赛.排序算法;

import java.util.ArrayList;

/**
 * @Author HYStar
 * @Date 2020/8/15 15:37
 */
public class 基数排序 {

    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        Util.print(randomArr);
        RadixSort(randomArr);
        Util.print(randomArr);
    }

    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }
}
