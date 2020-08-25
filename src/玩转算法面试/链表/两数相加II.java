package 玩转算法面试.链表;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2020/4/19 9:54
 */
public class 两数相加II {

    public static void main(String[] args) {
        int[] arr1 = {7, 2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = ListNode.createLinkedList(arr1, 4);
        ListNode l2 = ListNode.createLinkedList(arr2, 3);
        ListNode res = addTwoNumbers(l1, l2);
        ListNode.printLinkedList(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode a = l1;
        while (a != null) {
            s1.push(a);
            a = a.next;
        }
        a = l2;
        while (a != null) {
            s2.push(a);
            a = a.next;
        }
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int v1 = s1.isEmpty() ? 0 : s1.pop().val;
            int v2 = s2.isEmpty() ? 0 : s2.pop().val;
            int v = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            ListNode curr = new ListNode(v);
            curr.next = dummyHead.next;
            dummyHead.next = curr;
        }
        if (carry > 0) {
            ListNode curr = new ListNode(carry);
            curr.next = dummyHead.next;
            dummyHead.next = curr;
        }
        return dummyHead.next;
    }
}
