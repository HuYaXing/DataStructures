package 玩转算法面试.链表;

/**
 * @Author HYStar
 * @Date 2020/4/17 20:43
 */
public class 反转链表II {

    public static void main(String[] args) {

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null){
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (m > 1){
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode con = pre;
        ListNode tail = cur;
        while (n > 0){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        if (con == null){
            head = pre;
        }else {
            con.next = pre;
        }

        tail.next = cur;
        return head;
    }
}
