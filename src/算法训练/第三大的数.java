package 算法训练;

/**
 * @Author HYStar
 * @Date 2019/11/16 15:38
 */
public class 第三大的数 {

    public static void main(String[] args) {
        int[] arr = {-2147483648, 1, 2};
        System.out.println(thirdMax(arr));
    }

    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        return (third == Long.MIN_VALUE || third == second) ? (int) first : (int) third;
    }
}