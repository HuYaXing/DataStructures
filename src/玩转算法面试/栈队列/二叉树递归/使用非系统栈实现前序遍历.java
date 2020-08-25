package 玩转算法面试.栈队列.二叉树递归;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/4/21 10:41
 */
public class 使用非系统栈实现前序遍历 {


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