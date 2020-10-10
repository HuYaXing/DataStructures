package leetcode竞赛.九月.sf9_21.股票问题;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/21 下午8:23
 */
public class 买卖股票的最佳时机III {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //用一个哈希表存重复的调用
        Map<Key, Integer> map = new HashMap<>();
        return dfs(map, prices, 0, 0, 0);
    }

    /**
     * 暴力dfs
     *
     * @param prices
     * @param index  第几天
     * @param status 是买入还是卖出
     * @param k      交易了几次
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
        //定义三个变量，分别记录[不动]、[买]、[卖]
        int a = 0, b = 0, c = 0;
        //保持不动
        a = dfs(map, prices, index + 1, status, k);
        if (status == 1) {
            //递归处理卖的情况，这里需要将k+1，表示执行了一次交易
            b = dfs(map, prices, index + 1, 0, k + 1) + prices[index];
        } else {
            //递归处理买的情况
            c = dfs(map, prices, index + 1, 1, k) - prices[index];
        }
        map.put(key, Math.max(Math.max(a, b), c));
        //最终结果就是三个变量中的最大值
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
