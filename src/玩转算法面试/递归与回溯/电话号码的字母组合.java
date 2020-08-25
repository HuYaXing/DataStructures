package ��ת�㷨����.�ݹ������;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/27 9:29
 */
public class �绰�������ĸ��� {

    public static void main(String[] args) {
        �绰�������ĸ��� a = new �绰�������ĸ���();
        String digits = "23456789";
        System.out.println(a.letterCombinations(digits));
        System.out.println(a.letterCombinations(digits).size());
    }

    private String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        res.clear();
        if (digits.length() == 0){
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digit, int index, String s) {

        if (index == digit.length()) {
            //����s
            res.add(s);
            return;
        }

        char c = digit.charAt(index);
        //��ǰ���ֿ��Զ�Ӧ���ַ���
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digit, index + 1, s + letters.charAt(i));
        }
    }
}
