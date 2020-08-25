package 玩转算法面试.链表;

/**
 * @Author HYStar
 * @Date 2020/4/20 17:24
 */
public class 对链表进行插入排序 {

    public static void main(String[] args) {

    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = tmp;
        }
        return dummy.next;
    }

}
