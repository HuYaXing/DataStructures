package leetcode¾ºÈü.ÅÅĞòËã·¨;

/**
 * @Author HYStar
 * @Date 2020/8/15 10:11
 */
public class ¶ÑÅÅĞò {

    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        Util.print(randomArr);
        HeapSort(randomArr);
        Util.print(randomArr);
    }

    static int len;

    private static int[] HeapSort(int[] array) {
        len = array.length;
        buildMaxHeap(array);
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }

    private static void buildMaxHeap(int[] array) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    private static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        if (i * 2 + 1 < len && array[maxIndex] < array[i * 2 + 1]) {
            maxIndex = i * 2 + 1;
        }
        if (i * 2 + 2 < len && array[maxIndex] < array[i * 2 + 2]) {
            maxIndex = i * 2 + 2;
        }
        if (i != maxIndex) {
            swap(array, i, maxIndex);
            adjustHeap(array, maxIndex);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
