package stack;

/**
 * @Author HYStar
 * @Date 2019/11/9 17:40
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "-5-2*3+1";
        //创建两个栈，一个数栈，一个符号栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        //用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;

        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true) {
            //先得到每一个字符
            ch = expression.charAt(index);
            if (ch == '-') {
                keepNum += ch;
                if (index == 0) {
                    index++;
                    continue;
                }
            }

            if (operStack.isOper(ch)) {
                //判断符号栈是否为空
                if (!operStack.isEmpty()) {
                    //有符号判断优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //运算结果入数栈
                        numStack.push(res);
                        //当前符号入栈
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    if (ch == '-') {
                        operStack.push('+');
                    } else {
                        operStack.push(ch);
                    }
                }
            } else {
                //如果是数字，直接入数栈
//                numStack.push(ch - 48);
                //当处理多位数的时候，不能立即入栈，并且index需要多处理一位
                keepNum += ch;

                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字
                    if (operStack.isOper(expression.charAt(index + 1))) {
                        //是运算符，将数字入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }

            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //扫描结束时，按顺序将其他的数据计算出来
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            //运算结果入数栈
            numStack.push(res);
        }
        System.out.println("表达式：" + expression + "=" + res);
    }

}
