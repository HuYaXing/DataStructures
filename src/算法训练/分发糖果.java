package 算法训练;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/1/12 15:50
 */
public class 分发糖果 {

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy1(ratings));
    }

    public static int candy(int[] ratings) {

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        boolean flag = true;
        int sum = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < ratings.length; i++) {
                if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    flag = true;
                }
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    flag = true;
                }
            }
        }
        for (int candy : candies) {
            sum += candy;
        }
        return sum;

    }


    public static int candy1(int[] ratings) {

        int[] left = new int[ratings.length];

        int[] right = new int[ratings.length];

        Arrays.fill(left, 1);

        Arrays.fill(right, 1);

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                left[i + 1] = left[i] + 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                right[i - 1] = right[i] + 1;
            }
        }

        int res = 0;

        for (int i = 0; i < ratings.length; i++) {
            res += Math.max(left[i], right[i]);
        }

        return res;
    }

}
