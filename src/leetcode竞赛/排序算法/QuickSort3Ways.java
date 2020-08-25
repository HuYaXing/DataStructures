package leetcodeæ∫»¸.≈≈–ÚÀ„∑®;

import static leetcodeæ∫»¸.≈≈–ÚÀ„∑®.∂—≈≈–Ú.swap;

/**
 * @Author HYStar
 * @Date 2020/8/18 19:17
 */
public class QuickSort3Ways {

    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        Util.print(randomArr);
        sort(randomArr, 0, randomArr.length - 1);
        Util.print(randomArr);
    }

    private static void sort(int[] arr, int low, int high) {
        swap(arr, low, (int) (low + Math.random() * (high - low + 1)));

        int key = arr[low];
        int start = low;
        int end = high + 1;
        int i = low + 1;
        while (i < end) {
            if (arr[i] < key) {
                swap(arr, i, start + 1);
                i++;
                start++;
            } else if (arr[i] > key) {
                swap(arr, i, end - 1);
                end--;
            } else {
                i++;
            }
        }
        swap(arr, low, start);
        if (start > low) {
            sort(arr, low, start - 1);
        }
//        if (smallIndex < end) {
//            sort(arr, end, high);
//        }
    }

}
