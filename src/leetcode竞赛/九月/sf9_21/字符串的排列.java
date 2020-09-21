package leetcode����.����.sf9_21;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/21 ����5:53
 */
public class �ַ��������� {

    boolean[] memo;
    Set<String> set = new HashSet<>();

    public String[] permutation(String s) {
        memo = new boolean[s.length()];
        dfs(s, new StringBuilder());
        String[] res = new String[set.size()];
        int index = 0;
        for (String str : set) {
            res[index] = str;
            index++;
        }
        return res;
    }

    private void dfs(String s, StringBuilder sb) {
        if (sb.length() == s.length()) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!memo[i]){
                memo[i] = true;
                sb.append(s.charAt(i));
                dfs(s,sb);
                memo[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


}
