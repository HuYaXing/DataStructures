package √Ê ‘À„∑®.TX;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/6 21:31
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int temp = map.get(nums[i]);
            if (temp < n / 2) {
                System.out.println(nums[n / 2]);
            } else {
                System.out.println(nums[n / 2 - 1]);
            }
        }
    }


}
