package leetcode����.����.sf9_02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/2 ����8:28
 */
public class ��Ϊs�������������� {

    public int[][] findContinuousSequence(int target) {
        // �������ڵ���߽�
        int i = 1;
        // �������ڵ��ұ߽�
        int j = 1;
        // �������������ֵĺ�
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // �ұ߽������ƶ�
                sum += j;
                j++;
            } else if (sum > target) {
                // ��߽������ƶ�
                sum -= i;
                i++;
            } else {
                // ��¼���
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                // ��߽������ƶ�
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

}
