package leetcode竞赛.八月.sf8_23;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/23 20:02
 */
public class 删除节点 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (i != k - 1) {
                temp.next = new ListNode(val);
                temp = temp.next;
            }
        }
        ListNode cur = head.next;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        head = head.next;
    }
}

class ListNode {
    ListNode next;
    int val;
    public ListNode(int val) {
        this.val = val;
    }
}