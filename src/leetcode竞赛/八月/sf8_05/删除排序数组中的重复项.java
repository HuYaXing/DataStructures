package leetcode����.����.sf8_05;

/**
 * @Author HYStar
 * @Date 2020/8/5 10:01
 */
public class ɾ�����������е��ظ��� {

    public static void main(String[] args) {
        ɾ�����������е��ظ��� main = new ɾ�����������е��ظ���();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        main.removeDuplicates(nums);
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0){
            return 0;
        }
        int next = 1;
        int val = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[i] != val){
                val = nums[i];
                nums[next] = nums[i];
                next++;
            }
        }
        return next;
    }

}
