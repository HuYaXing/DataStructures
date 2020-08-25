package leetcode竞赛.八月.sf8_07;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/8/7 22:56
 */
public class 两个链表的第一个公共节点 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}