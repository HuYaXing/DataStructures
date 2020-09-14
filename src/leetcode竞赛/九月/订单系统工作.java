package leetcode竞赛.九月;

import java.util.*;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/8 下午7:34
 */
public class 订单系统工作 {

    static PriorityQueue<String> res = new PriorityQueue<>(Comparator.naturalOrder());
    static List<Boolean> flag = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        dfs(strs, 0, new ArrayList<>(), false);
        int index = 0;
        for (String r : res) {
            if (flag.get(index)) {
                r += "--circular dependence";
            }
            index++;
            System.out.println(r);
        }
    }

    private static void dfs(String[] strs, int index, ArrayList<Character> path, boolean is) {
        if (index == strs.length) {
            String str = builderString(path, is);
            res.add(str);
            return;
        }
        for (int i = 0; i < strs[index].length(); i++) {
            if (path.contains(strs[index].charAt(i))) {
                is = true;
            }
            path.add(strs[index].charAt(i));
            dfs(strs, index + 1, path, is);
            is = false;
            path.remove(path.size() - 1);
        }
    }

    public static String builderString(List<Character> path, boolean is) {
        StringBuilder sb = new StringBuilder();
        for (char c : path) {
            sb.append(c);
        }
        flag.add(is);
        return sb.toString();
    }
}
