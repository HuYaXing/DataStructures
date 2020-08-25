package 蓝桥杯备战.JavaB组2014年;

/**
 * @Author HYStar
 * @Date 2020/5/21 15:09
 */
public class 猜字母03 {

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrs";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 106; i++) {
            sb.append(s);
        }
        System.out.println(sb.length());
        while (sb.length() > 1) {
            int len = sb.length();
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i < len; i += 2) {
                temp.append(sb.charAt(i));
            }
            sb = temp;
        }
        System.out.println(sb.toString());
    }

}
