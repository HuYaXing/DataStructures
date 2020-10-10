package leetcode����.ʮ��.sf10_9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/10/9 ����5:03
 */
public class ԲȦ�����ʣ�µ����� {

    public static void main(String[] args) {
        System.out.println(lastRemaining(10, 17));
    }

    public static int lastRemaining(int n, int m) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i);
        }
        int index = -1;
        while (nums.size() > 1) {
            index += m;
            index %= nums.size();
            nums.remove(index);
            index--;
        }
        return nums.get(0);
    }

}
