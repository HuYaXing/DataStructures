package 玩转算法面试.链表;

/**
 * @Author HYStar
 * @Date 2020/4/18 10:46
 */
public class 删除排序链表中的重复元素 {

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
