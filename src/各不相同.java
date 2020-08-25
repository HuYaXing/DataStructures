import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/7/29 17:34
 */
public class 各不相同 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Long> set = new LinkedHashSet<>();
        long n = scanner.nextLong();
        long[] nums = new long[(int) n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            while (set.contains(num)) {
                set.remove(num);
                num = num * 2;
            }
            set.add(num);
        }
        for (Long num : set) {
            System.out.println(num + " ");
        }
    }

}
