package leetcode����.����.sf7_29;

/**
 * @Author HYStar
 * @Date 2020/7/29 22:53
 */
public class �����е�����k���ڵ� {

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
