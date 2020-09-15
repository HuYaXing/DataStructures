package 面试算法.小米;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/15 19:50
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] nums = new int[256];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (nums[str.charAt(i)]++ == 0){
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

}
