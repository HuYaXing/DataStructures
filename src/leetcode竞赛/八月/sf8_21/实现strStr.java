package leetcode����.����.sf8_21;

/**
 * @Author HYStar
 * @Date 2020/8/21 9:42
 */
public class ʵ��strStr {

    /**
     * ��ʱ
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

}
