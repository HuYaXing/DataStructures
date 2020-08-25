package ��ת�㷨����.����;

/**
 * @Author HYStar
 * @Date 2020/4/19 9:24
 */
public class ������� {

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ListNode l1 = ListNode.createLinkedList(arr1, 3);
        ListNode l2 = ListNode.createLinkedList(arr2, 3);
        ListNode res = addTwoNumbers(l1, l2);
        ListNode.printLinkedList(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null){
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
