package ��ת�㷨����.����.ָ����ײ;

/**
 * @Author HYStar
 * @Date 2020/4/9 21:39
 */
public class ��ת�ַ��� {

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
