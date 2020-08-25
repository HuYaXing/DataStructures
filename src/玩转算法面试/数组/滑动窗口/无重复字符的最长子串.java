package 玩转算法面试.数组.滑动窗口;

/**
 * @Author HYStar
 * @Date 2020/4/10 9:36
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        //用来存储滑动窗口中字符的出现频率
        int[] freq = new int[256];

        int l = 0;
        int r = -1;

        int res = 0;

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
                res = Math.max(res, r - l + 1);
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
        }
        return res;
    }

}
