package leetcode竞赛.七月.sf7_29;

/**
 * @Author HYStar
 * @Date 2020/7/29 23:11
 */
public class 删除链表的节点 {

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
