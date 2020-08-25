package 玩转算法面试.链表;

/**
 * @Author HYStar
 * @Date 2020/4/19 16:29
 */
public class 移除链表元素 {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int[] arr = {6, 7, 6, 6};
        ListNode head = ListNode.createLinkedList(arr, 4);
        ListNode.printLinkedList(head);
        ListNode res = removeElements(head, 6);
        ListNode.printLinkedList(res);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel,curr = head;
        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            }else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }

}
