package leetcode����.����.sf9_21.��Ʊ����;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/21 ����8:23
 */
public class ������Ʊ�����ʱ��III {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //��һ����ϣ����ظ��ĵ���
        Map<Key, Integer> map = new HashMap<>();
        return dfs(map, prices, 0, 0, 0);
    }

    /**
     * ����dfs
     *
     * @param prices
     * @param index  �ڼ���
     * @param status �����뻹������
     * @param k      �����˼���
     * @return
     */
    private int dfs(Map<Key, Integer> map, int[] prices, int index, int status, int k) {
        Key key = new Key(index, status, k);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (index == prices.length || k == 2) {
            return 0;
        }
        //���������������ֱ��¼[����]��[��]��[��]
        int a = 0, b = 0, c = 0;
        //���ֲ���
        a = dfs(map, prices, index + 1, status, k);
        if (status == 1) {
            //�ݹ鴦�����������������Ҫ��k+1����ʾִ����һ�ν���
            b = dfs(map, prices, index + 1, 0, k + 1) + prices[index];
        } else {
            //�ݹ鴦��������
            c = dfs(map, prices, index + 1, 1, k) - prices[index];
        }
        map.put(key, Math.max(Math.max(a, b), c));
        //���ս���������������е����ֵ
        return map.get(key);
    }

    private class Key {
        final int index;
        final int status;
        final int k;

        Key(int index, int status, int k) {
            this.index = index;
            this.status = status;
            this.k = k;
        }

        @Override
        public boolean equals(Object obj) {
            Key other = (Key) obj;
            if (index == other.index && status == other.status && k == other.k) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.index + this.status + this.k;
        }
    }

}
