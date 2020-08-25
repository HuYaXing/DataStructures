package leetcode竞赛.七月.sf7_31;

/**
 * @Author HYStar
 * @Date 2020/7/31 21:56
 */
public class 魔术索引 {

    public static void main(String[] args) {
        魔术索引 main = new 魔术索引();
        int[] nums = {1,1,1};
        main.findMagicIndex(nums);
    }

    public int findMagicIndex(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == i){
//                return i;
//            }
//        }
//        return -1;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i) {
                return i;
            } else if (nums[i] > i) {
                i = nums[i];
            }else {
                i++;
            }
        }
        return -1;
    }

}
