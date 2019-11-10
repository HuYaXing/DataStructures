package stack;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2019/11/9 16:22
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("s:��ʾջ");
            System.out.println("e:�˳�");
            System.out.println("pu:��ջ");
            System.out.println("po:��ջ");

            key = scanner.next();
            switch (key) {
                case "s":
                    stack.list();
                    break;
                case "pu":
                    System.out.println("����һ������");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "po":
                    try {
                        int res = stack.pop();
                        System.out.println("ȡ����" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("�˳���");
    }

}

class ArrayStack {
    private int maxSize;
    //�������
    private int[] stack;
    //ջ������ʼ��Ϊ-1
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //����ջ����ֵ
    public int peek(){
        return stack[top];
    }

    //�ж�ջ�Ƿ���
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //ջ��
    public boolean isEmpty() {
        return top == -1;
    }

    //��ջ
    public void push(int value) {
        if (isFull()) {
            System.out.println("��");
            return;
        }
        top++;
        stack[top] = value;
    }

    //��ջ
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("��");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //����
    public void list() {
        if (isEmpty()) {
            System.out.println("��");
            return;
        }
        //�Ӷ�����ӡ
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[" + i + "]=" + stack[i]);
        }
    }

    //��������������ȼ�������Խ�����ȼ�Խ��
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //�ж��ǲ���һ�������
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //���㷽��
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}