package leetcode����.����.sf8_20;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/8/20 19:31
 */
public class Main {


    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // ע�� Java ȡģ�������ԣ���������Ϊ����ʱȡģ���Ϊ��������Ҫ����
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

}
