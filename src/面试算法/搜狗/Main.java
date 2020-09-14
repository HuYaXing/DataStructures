package √Ê ‘À„∑®.À—π∑;

import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/9/5 18:23
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numberofprize(100, 100, 1));
    }

    public int numberofprize(int a, int b, int c) {
        // write code here
        int[] nums = new int[3];
        nums[0] = a;
        nums[1] = b;
        nums[2] = c;
        Arrays.sort(nums);
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= res;
        }

        int min = nums[1];
        int d = min / 2;
        nums[2] -= 2 * d;
        res += d;

        min = nums[2];
        d = min / 4;
        res += d;
        return res;
    }

    public int getHouses(int t, int[] xa) {
        // write code here
        if (xa.length <= 2) {
            return 2;
        }
        int res = 2;
        double last = xa[0] + xa[1] / 2.0;
        for (int i = 2; i < xa.length; i += 2) {
            double with = xa[i + 1] / 2.0;
            if (Math.abs(xa[i] - last - with) > t) {
                res += 2;
            } else if (Math.abs(xa[i] - last - with - t) < 0.001) {
                res += 1;
            }
            last = xa[i] + with;
        }
        return res;
    }

}
