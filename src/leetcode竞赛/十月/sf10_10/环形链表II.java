package leetcode竞赛.十月.sf10_10;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/10/10 上午11:26
 */
public class 环形链表II {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 100447; i++) {
            set.add(scanner.nextLine());
        }
        System.out.println(set.size());
    }
    
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }

//    public ListNode detectCycle1(ListNode head) {
//
//    }

}

                                                                                                                    class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}