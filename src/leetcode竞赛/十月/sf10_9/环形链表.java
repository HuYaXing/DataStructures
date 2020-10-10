package leetcode竞赛.十月.sf10_9;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/10/9 下午2:02
 */
public class 环形链表 {

    public boolean hasCycle(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (one != null && two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
            if (one == two) {
                return true;
            }
        }
        return false;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}