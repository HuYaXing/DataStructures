package leetcode竞赛.五月.sf5_18;

/**
 * @Author HYStar
 * @Date 2020/5/18 19:08
 */
public class 反转字符串中的单词III {

    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            res.append(new StringBuilder(word).reverse().toString() + " ");
        }
        return res.toString().trim();
    }

}
