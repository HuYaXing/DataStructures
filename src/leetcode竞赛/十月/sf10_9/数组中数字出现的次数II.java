package leetcode����.ʮ��.sf10_9;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/10/9 ����2:57
 */
public class ���������ֳ��ֵĴ���II {

    public static void main(String[] args) {
        System.out.println(~7);
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

}
