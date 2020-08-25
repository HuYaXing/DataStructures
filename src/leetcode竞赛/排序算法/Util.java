package leetcode¾ºÈü.ÅÅĞòËã·¨;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/8/15 11:01
 */
public class Util {
    public static int[] getRandomArr(int length, int min, int max) {
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = (int) (min + Math.random() * (max - min + 1));
        }
        return a;
    }
    public static void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
    public static Integer[] getRandomArr1(int length, int min, int max) {
        Integer[] a = new Integer[length];
        for (int i = 0; i < length; i++) {
            a[i] = (int) (min + Math.random() * (max - min + 1));
        }
        return a;
    }
    public static void print1(Integer[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
