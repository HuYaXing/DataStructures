package 玩转算法面试.动态规划.练习题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/5/7 20:30
 */
public class 单词拆分 {

    public static void main(String[] args) {
        单词拆分 main = new 单词拆分();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(main.wordBreak("catsandog", wordDict));
    }

    /**
     * 超出时间限制
     *
     * @param s
     * @param wordDict
     * @return
     */
    Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        return word_Break(s, new HashSet(wordDict), 0);
    }

    public boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return memo[start] = true;
            }
        }
        return false;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
