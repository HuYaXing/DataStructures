package stack;

/**
 * @Author HYStar
 * @Date 2019/11/9 17:40
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "-5-2*3+1";
        //��������ջ��һ����ջ��һ������ջ
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        //����ɨ��
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;

        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true) {
            //�ȵõ�ÿһ���ַ�
            ch = expression.charAt(index);
            if (ch == '-') {
                keepNum += ch;
                if (index == 0) {
                    index++;
                    continue;
                }
            }

            if (operStack.isOper(ch)) {
                //�жϷ���ջ�Ƿ�Ϊ��
                if (!operStack.isEmpty()) {
                    //�з����ж����ȼ�
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //����������ջ
                        numStack.push(res);
                        //��ǰ������ջ
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
                //��������֣�ֱ������ջ
//                numStack.push(ch - 48);
                //�������λ����ʱ�򣬲���������ջ������index��Ҫ�ദ��һλ
                keepNum += ch;

                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //�ж���һ���ַ��ǲ�������
                    if (operStack.isOper(expression.charAt(index + 1))) {
                        //�����������������ջ
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

        //ɨ�����ʱ����˳�����������ݼ������
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            //����������ջ
            numStack.push(res);
        }
        System.out.println("���ʽ��" + expression + "=" + res);
    }

}
