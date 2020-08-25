package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2019/11/11 22:07
 */
public class PolandNotation {

    public static void main(String[] args) {
        //����һ���沨�����ʽ(��׺���ʽ)
        //(3+4)*5-6 => 34+5*6-
        String suffixExpression = "3 4 + 5 * 6 - ";
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);

        System.out.println(calculator(rpnList));
    }

    //���沨�����ʽ����ArrayList
    public static List<String> getListString(String suffixExpression) {
        //���ַ����ָ�
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();

        Collections.addAll(list, split);
        return list;
    }

    //����沨�����ʽ�ļ���
    public static int calculator(List<String> list) {
        //����һ��ջ
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            //ʹ��������ʽ,����Ƕ�λ��
            if (item.matches("\\d+")) {
                //��ջ
                stack.push(item);
            } else {
                //pop����������������
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("���������");
                }
                //��res��ջ
                stack.push(res + "");
            }
        }
        //�������stack�еľ���������
        return Integer.parseInt(stack.pop());
    }

}
