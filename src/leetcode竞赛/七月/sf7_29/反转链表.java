package leetcode竞赛.七月.sf7_29;

/**
 * @Author HYStar
 * @Date 2020/7/29 23:26
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode pre = null,cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
