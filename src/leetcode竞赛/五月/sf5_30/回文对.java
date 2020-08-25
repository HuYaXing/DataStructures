package leetcode竞赛.五月.sf5_30;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/5/30 17:37
 */
public class 回文对 {

    public static void main(String[] args) {
        回文对 main = new 回文对();
        String[] words = {"abcd","dcba","lls","s","sssll"};
        System.out.println(main.palindromePairs(words));
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words.length <= 1) {
            return res;
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                List<Integer> temp;
                if (check(words[i], words[j])) {
                    temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
                if (check(words[j], words[i])) {
                    temp = new ArrayList<>();
                    temp.add(j);
                    temp.add(i);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private boolean check(String word, String word1) {
        String str = word + word1;
        int start = 0;
        int end = str.length() - 1;

        while (start < end){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
