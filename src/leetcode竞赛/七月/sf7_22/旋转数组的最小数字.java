package leetcode竞赛.七月.sf7_22;

/**
 * @Author HYStar
 * @Date 2020/7/22 22:34
 */
public class 旋转数组的最小数字 {

    public static void main(String[] args) {
        旋转数组的最小数字 main = new 旋转数组的最小数字();
        int[] numbers = {1, 1, 1, 1, 1};
        System.out.println(main.minArray(numbers));
    }

    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

}
