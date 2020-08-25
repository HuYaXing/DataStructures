package leetcode¾ºÈü.½£Ö¸Offer;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/6/10 15:43
 */
public class CQueue {

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(100);
        int param_2 = obj.deleteHead();
    }


    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }

    public void appendTail(int value) {
        stack1.push(value);
        size++;
    }

    public int deleteHead() {
        if(size==0){
            return -1;
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        size--;
        return stack2.pop();
    }

}
