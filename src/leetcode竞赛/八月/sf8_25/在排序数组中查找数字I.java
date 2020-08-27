package leetcode竞赛.八月.sf8_25;

public class 在排序数组中查找数字I {

    public static void main(String[] args) {
        在排序数组中查找数字I main = new 在排序数组中查找数字I();
        int[] nums = {2,2};
        System.out.println(main.search(nums, 2));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res++;
                int i = mid - 1;
                while (i >= 0 && nums[i] == target) {
                    res++;
                    i--;
                }
                int j = mid + 1;
                while (j < nums.length && nums[j] == target) {
                    res++;
                    j++;
                }
                return res;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

}
