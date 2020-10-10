package leetcode竞赛.九月.sf9_29;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/29 下午7:40
 */
public class 反转链表 {

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