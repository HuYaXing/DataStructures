package 玩转算法面试.链表;

/**
 * @Author HYStar
 * @Date 2020/4/19 22:10
 */
public class 两两交换链表中的节点 {

    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }
        return dummyHead.next;
    }
}
