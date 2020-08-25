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
        //定义一个逆波兰表达式(后缀表达式)
        //(3+4)*5-6 => 34+5*6-
        String suffixExpression = "3 4 + 5 * 6 - ";
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);

        System.out.println(calculator(rpnList));
    }

    //将逆波兰表达式放入ArrayList
    public static List<String> getListString(String suffixExpression) {
        //将字符串分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();

        Collections.addAll(list, split);
        return list;
    }

    //完成逆波兰表达式的计算
    public static int calculator(List<String> list) {
        //创建一个栈
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            //使用正则表达式,如果是多位数
            if (item.matches("\\d+")) {
                //入栈
                stack.push(item);
            } else {
                //pop出两个数，并运算
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
                    throw new RuntimeException("运算符有误！");
                }
                //把res入栈
                stack.push(res + "");
            }
        }
        //最后留在stack中的就是运算结果
        return Integer.parseInt(stack.pop());
    }

}
