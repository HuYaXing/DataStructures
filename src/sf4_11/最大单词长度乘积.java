package sf4_11;

/**
 * @Author HYStar
 * @Date 2020/4/11 20:57
 */
public class 最大单词长度乘积 {

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct(words));
    }

    public static int maxProduct(String[] words) {
        int[] temp = new int[26];

        int res = 0;
        boolean is = true;
        for (int i = 0; i < words.length - 1; i++) {
            for (int k = 0; k < words[i].length(); k++) {
                temp[words[i].charAt(k) - 'a']++;
            }
            for (int j = i + 1; j < words.length; j++) {
                is = true;
                for (int k = 0; k < words[j].length(); k++) {
                    if (temp[words[j].charAt(k) - 'a'] != 0) {
                        is = false;
                        break;
                    }
                }
                if (is){
                    int num = words[i].length() * words[j].length();
                    res = res < num ? num : res;
                }
            }
            temp = new int[26];
        }
        return res;
    }

}
