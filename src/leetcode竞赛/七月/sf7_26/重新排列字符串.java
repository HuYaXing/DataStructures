package leetcode竞赛.七月.sf7_26;

/**
 * @Author HYStar
 * @Date 2020/7/26 10:30
 */
public class 重新排列字符串 {

    public String restoreString(String s, int[] indices) {
        char[] ch = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            ch[indices[i]] = s.charAt(i);
        }
        return String.valueOf(ch);
    }

}
