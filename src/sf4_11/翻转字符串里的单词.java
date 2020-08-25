package sf4_11;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/11 16:02
 */
public class ��ת�ַ�����ĵ��� {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        int start = 0;
        int end = 0;

        List<String> list = new LinkedList<>();
        boolean isString = false;
        while (end < s.length()) {

            if (s.charAt(end) != ' ') {
                isString = true;
            } else {
                start = end + 1;
            }
            end++;
            if (isString && end <= s.length()) {
                if (end == s.length()) {
                    list.add(s.substring(start, end));
                } else if (s.charAt(end) == ' ') {
                    list.add(s.substring(start, end));
                    isString = false;
                    start = end + 1;
                }
            }
        }

        System.out.println(list);
        String res = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == 0) {
                res = res + list.get(i);
            } else {
                res = res + list.get(i) + " ";
            }
        }

        return res;
    }

    public String reverseWords1(String s) {
        // ��ȥ��ͷ��ĩβ�Ŀհ��ַ�
        s = s.trim();
        // ����ƥ�������Ŀհ��ַ���Ϊ�ָ����ָ�
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }


    //��
    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // ȥ���ַ�����ͷ�Ŀհ��ַ�
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // ȥ���ַ���ĩβ�Ŀհ��ַ�
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // ���ַ��������Ŀհ��ַ�ȥ��
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // ѭ�������ʵ�ĩβ
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // ��ת����
            reverse(sb, start, end - 1);
            // ����start��ȥ����һ������
            start = end + 1;
            ++end;
        }
    }

    public String reverseWords2(String s) {
        StringBuilder sb = trimSpaces(s);

        // ��ת�ַ���
        reverse(sb, 0, sb.length() - 1);

        // ��תÿ������
        reverseEachWord(sb);

        return sb.toString();
    }

    public String reverseWords3(String s) {
        int left = 0, right = s.length() - 1;
        // ȥ���ַ�����ͷ�Ŀհ��ַ�
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // ȥ���ַ���ĩβ�Ŀհ��ַ�
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // ������ push �����е�ͷ��
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }


}
