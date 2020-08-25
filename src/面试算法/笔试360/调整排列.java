package 面试算法.笔试360;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/22 20:08
 */
public class 调整排列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        ArrayList<Integer> operation = new ArrayList<>();
        int flag = 0;
        int a = 0;
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            if (flag == 0){
                flag = num;
                a++;
            }
            if (flag == num){
                a++;
            }
            operation.add(num);

        }

        for (int i = 0; i < operation.size(); i++) {
            if (operation.get(i) == 1) {
                int temp = nums[N - 1];
                for (int j = nums.length - 1; j >= 1; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[0] = temp;
            } else {
                for (int j = 0; j < N - 1; j += 2) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
