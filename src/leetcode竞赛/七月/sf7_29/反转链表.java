package leetcode����.����.sf7_29;

/**
 * @Author HYStar
 * @Date 2020/7/29 23:26
 */
public class ��ת���� {

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
