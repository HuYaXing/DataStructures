package 玩转算法面试.数组.指针碰撞;

/**
 * @Author HYStar
 * @Date 2020/4/9 21:39
 */
public class 反转字符串 {

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

    }

}
