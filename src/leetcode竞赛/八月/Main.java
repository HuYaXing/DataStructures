package leetcode¾ºÈü.°ËÔÂ;

/**
 * @Author HYStar
 * @Date 2020/9/6 11:48
 */
public class Main {

    public static void main(String[] args) {
//        Main main = new Main();
//        System.out.println(main.modifyString("?a?ub???w?b"));
        double a = 0.2515641864165416854156165165;
        float c = 2.011111111111111111111f;
        float b = (float) a;
        Integer x = Integer.valueOf(2);
        x.intValue();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(0.1 * 3);
//        System.out.println(0.1 + 0.3);
    }

    public String modifyString(String s) {
        if (s.equals("?")) {
            return "a";
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '?') {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (i == 0 && j != chars[i + 1]) {
                        chars[i] = j;
                        sb.append(j);
                        break;
                    } else if (i == s.length() - 1 && j != chars[i - 1]) {
                        chars[i] = j;
                        sb.append(j);
                        break;
                    } else if (i != s.length() - 1 && i != 0 && j != chars[i - 1] && j != chars[i + 1]) {
                        chars[i] = j;
                        sb.append(j);
                        break;
                    }
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}
