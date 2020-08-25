package Ð¡ÆÆÕ¾;

/**
 * @Author HYStar
 * @Date 2020/8/13 19:43
 */
public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        int[] arr = {7, 2, 1, 10};
        System.out.println(main.Game24Points(arr));
    }


    boolean[] memo;
    char[] chars = {'+', '-', '*', '/'};

    public boolean Game24Points(int[] arr) {
        // write code here
        memo = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            memo[i] = true;
            if (f(arr, 0, arr[i], 1)) {
                return true;
            }
            memo[i] = false;
        }
        return false;
    }

    private boolean f(int[] arr, int perNum, int num, int index) {
        if (index == arr.length) {
            return num == 24;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!memo[i]) {

                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == '+') {
                        memo[i] = true;
                        if (f(arr, num, num + arr[i], index + 1)){
                            return true;
                        }
                        memo[i] = false;
                    }
                    if (chars[j] == '-') {
                        memo[i] = true;
                        if (f(arr, num, num - arr[i], index + 1)){
                            return true;
                        }
                        memo[i] = false;
                    }
                    if (chars[j] == '*') {
                        memo[i] = true;
                        if (f(arr, num, perNum + (num - perNum) * arr[i], index + 1)){
                            return true;
                        }
                        memo[i] = false;
                    }
                    if (chars[j] == '/') {
                        memo[i] = true;
                        if (f(arr, num, perNum + (num - perNum) / arr[i], index + 1)){
                            return true;
                        }
                        memo[i] = false;
                    }
                }

            }
        }
        return false;
    }

}
