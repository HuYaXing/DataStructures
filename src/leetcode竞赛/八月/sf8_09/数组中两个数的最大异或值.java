package leetcode����.����.sf8_09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/8/9 9:31
 */
public class ��������������������ֵ {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1 << 30));
    }

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            // ע���1��ע�Ᵽ��ǰ׺�ķ�����mask ������������
            // �����Ҳ�ǿ��Ե� mask = mask ^ (1 << i);
            mask = mask | (1 << i);

            // System.out.println(Integer.toBinaryString(mask));
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // ע���2������ʹ�� & ������ǰ׺����˼���Ӹ�λ����λ��
                set.add(num & mask);
            }

            // �����ȼٶ��� n λΪ 1 ��ǰ n-1 λ res Ϊ֮ǰ�������
            int temp = res | (1 << i);
            for (Integer prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }

}
