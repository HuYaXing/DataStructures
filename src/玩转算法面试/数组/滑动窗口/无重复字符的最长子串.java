package ��ת�㷨����.����.��������;

/**
 * @Author HYStar
 * @Date 2020/4/10 9:36
 */
public class ���ظ��ַ�����Ӵ� {

    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        //�����洢�����������ַ��ĳ���Ƶ��
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
