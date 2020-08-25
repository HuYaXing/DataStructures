package 玩转算法面试.链表;

/**
 * @Author HYStar
 * @Date 2020/4/19 9:10
 */
public class 奇偶链表 {

    public static void main(String[] args) {

    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd_head = new ListNode(0);
        ListNode odd = odd_head;
        ListNode even_head = new ListNode(0);
        ListNode even = even_head;

        int num = 3;
        while (head != null) {
            if (num % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            num++;
        }
        even.next = null;
        odd.next = even_head.next;
        return odd_head.next;
    }

}
