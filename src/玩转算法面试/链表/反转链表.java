package 玩转算法面试.链表;

/**
 * @Author HYStar
 * @Date 2020/4/17 20:23
 */
public class 反转链表 {

    public static void main(String[] args) {
        int[] arr = {1};
        int n = 5;
        ListNode head = ListNode.createLinkedList(arr, 1);
        ListNode.printLinkedList(head);
        ListNode listNode = reverseList(head);
        ListNode.printLinkedList(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void printLinkedList(ListNode head) {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + " -> ");
            curNode = curNode.next;
        }
        System.out.println("null");
    }

    public static ListNode createLinkedList(int[] arr, int n) {
        if (n == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;

        for (int i = 1; i < n; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

}
