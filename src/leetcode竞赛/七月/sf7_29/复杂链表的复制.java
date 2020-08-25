package leetcode竞赛.七月.sf7_29;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/7/29 23:31
 */
public class 复杂链表的复制 {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>(); //创建HashMap集合
        Node cur = head;
        //复制结点值
        while (cur != null) {
            //存储put:<key,value1>
            map.put(cur, new Node(cur.val)); //顺序遍历，存储老结点和新结点(先存储新创建的结点值)
            cur = cur.next;
        }
        //复制结点指向
        cur = head;
        while (cur != null) {
            //得到get:<key>.value2,3
            map.get(cur).next = map.get(cur.next); //新结点next指向同旧结点的next指向
            map.get(cur).random = map.get(cur.random); //新结点random指向同旧结点的random指向
            cur = cur.next;
        }

        //返回复制的链表
        return map.get(head);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}