package leetcode竞赛.八月.sf8_08;

/**
 * @Author HYStar
 * @Date 2020/8/8 22:30
 */
public class 第k个缺失的正整数 {

    public static void main(String[] args) {
        第k个缺失的正整数 main = new 第k个缺失的正整数();
        int[] arr = {1, 2, 3, 4};
        System.out.println(main.findKthPositive(arr, 2));
    }


    public int findKthPositive(int[] arr, int k) {
        int index = 0;
        int len = arr.length;
        int i = 0;
        int num = 1;
        while (true) {
            if (i == len) {
                break;
            }
            if (index == k) {
                return num - 1;
            }
            if (arr[i] == num) {
                i++;
            } else {
                index++;
            }
            num++;
        }
        return num - 1 + k - index;
    }

}
