package ��ת�㷨����.����;

/**
 * @Author HYStar
 * @Date 2020/4/18 10:46
 */
public class ɾ�����������е��ظ�Ԫ�� {

    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null){
            ListNode next = cur.next;
            if (cur.val == next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
