package 玩转算法面试.链表;

/**
 * @Author HYStar
 * @Date 2020/4/19 21:29
 */
public class 删除排序链表中的重复元素II {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        ListNode head = ListNode.createLinkedList(arr, 5);
        ListNode.printLinkedList(head);
        ListNode listNode = deleteDuplicates(head);
        ListNode.printLinkedList(listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode pre = sentinel, cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                    if (cur.next == null) {
                        pre.next = pre.next.next;
                        return sentinel.next;
                    }
                }
                cur = cur.next;
                pre.next = pre.next.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return sentinel.next;
    }
}
