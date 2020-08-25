package leetcode竞赛.五月.sf5_18;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/5/18 20:08
 */
public class 播放列表的数量 {

    public static void main(String[] args) {
        播放列表的数量 main = new 播放列表的数量();
        System.out.println(main.numMusicPlaylists(16, 16, 4));
    }

    int res = 0;

    public int numMusicPlaylists(int N, int L, int K) {
        f(N, L, K, new HashMap<>(), new LinkedList<>());
        return res;
    }

    /**
     * 超出时间限制
     *
     * @param N
     * @param L
     * @param K
     * @param memo
     * @param path
     */
    private void f(int N, int L, int K, Map<Integer, Integer> memo, LinkedList<Integer> path) {
        if (path.size() == L) {
            if (memo.size() == N) {
                res++;
                System.out.println(path);
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!memo.containsKey(i) || memo.get(i) <= 0) {
                boolean flag = memo.containsKey(i);
                int temp = 0;
                if (flag) {
                    temp = memo.get(i);
                }
                Set<Integer> set = memo.keySet();
                for (Integer key : set) {
                    memo.put(key, memo.get(key) - 1);
                }
                memo.put(i, K);
                path.add(i);
                f(N, L, K, memo, path);
                for (Integer key : set) {
                    memo.put(key, memo.get(key) + 1);
                }
                if (flag) {
                    memo.put(i, temp);
                } else {
                    memo.remove(i);
                }
                path.removeLast();
            }
        }
    }
    public int numMusicPlaylists1(int N, int L, int K) {
        int MOD = 1_000_000_007;

        long[][] dp = new long[L+1][N+1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; ++i)
            for (int j = 1; j <= N; ++j) {
                dp[i][j] += dp[i-1][j-1] * (N-j+1);
                dp[i][j] += dp[i-1][j] * Math.max(j-K, 0);
                dp[i][j] %= MOD;
            }

        return (int) dp[L][N];
    }
}
