package leetcode����.����.sf8_05;

/**
 * @Author HYStar
 * @Date 2020/8/5 9:29
 */
public class �ƶ��� {

    public void moveZeroes(int[] nums) {
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                //Ҳ����ֱ�ӽ�����֮��Ͳ���Ҫ�������������ݴ�����
                nums[next] = nums[i];
                next++;
            }
        }
        for (int i = next; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
