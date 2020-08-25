package ��ת�㷨����.ջ����.�������ݹ�;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/4/21 10:41
 */
public class ʹ�÷�ϵͳջʵ��ǰ����� {


    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go",root));
        while (!stack.isEmpty()){
            Command command = stack.pop();
            if ("print".equals(command.s)){
                res.add(command.node.val);
            }else {
                if (command.node.right != null){
                    stack.push(new Command("go",command.node.right));
                }
                if (command.node.left != null){
                    stack.push(new Command("go",command.node.left));
                }
                stack.push(new Command("print",command.node));
            }
        }
        return res;
    }


}
class Command{
    String s;
    TreeNode node;
    public Command(String s,TreeNode node){
        this.s = s;
        this.node = node;
    }
}