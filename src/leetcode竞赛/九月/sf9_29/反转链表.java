package leetcode����.����.sf9_29;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/29 ����7:40
 */
public class ��ת���� {

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode pre = null,cur = head;
        while(cur != null){
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
}