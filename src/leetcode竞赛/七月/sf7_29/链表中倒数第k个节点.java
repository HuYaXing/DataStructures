package leetcode竞赛.七月.sf7_29;

/**
 * @Author HYStar
 * @Date 2020/7/29 22:53
 */
public class 链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++){
            former = former.next;
        }
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

}
