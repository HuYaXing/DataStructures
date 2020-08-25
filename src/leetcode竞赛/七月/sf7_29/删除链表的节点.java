package leetcode����.����.sf7_29;

/**
 * @Author HYStar
 * @Date 2020/7/29 23:11
 */
public class ɾ������Ľڵ� {

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head.next;
        ListNode pre = head;

        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null){
            pre.next = cur.next;
        }
        return head;
    }

}
