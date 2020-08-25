package leetcode竞赛.排序算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/8/15 15:05
 */
public class 桶排序 {

    public static void main(String[] args) {
        Integer[] randomArr = Util.getRandomArr1(10, 1, 60);
        Util.print1(randomArr);
        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.asList(randomArr);
        BucketSort(list,4);
        Util.print1(randomArr);
    }

    public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2) {
            return array;
        }
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            // 如果带排序数组中有重复数字时  感谢 @见风任然是风 朋友指出错误
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketCount == 1) {
                    bucketSize--;
                }
                ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }
}
