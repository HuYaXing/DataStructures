package leetcodeæ∫»¸.≈≈–ÚÀ„∑®;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/8/15 8:57
 */
public class πÈ≤¢≈≈–Ú {

    public static void main(String[] args) {
        int[] array = {9, 5, 6, 3, 5, 0, 2};
        System.out.println(Arrays.toString(MergeSort(array)));
    }

    public static int[] MergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            }else if (j >= right.length){
                result[index] = left[i++];
            }else if (left[i] > right[j]){
                result[index] = right[j++];
            }else {
                result[index] = left[i++];
            }
        }
        return result;
    }

}
