package leetcode����.����.sf7_31;

/**
 * @Author HYStar
 * @Date 2020/7/31 21:56
 */
public class ħ������ {

    public static void main(String[] args) {
        ħ������ main = new ħ������();
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
