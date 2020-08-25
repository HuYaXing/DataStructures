package 玩转算法面试.优先队列的使用;

import java.util.PriorityQueue;

/**
 * @Author HYStar
 * @Date 2020/4/24 22:24
 */
public class 合并K个排序链表 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5};
        int[] arr1 = {1, 3, 4};
        int[] arr2 = {2, 6};
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.createLinkedList(arr, 3);
        lists[1] = ListNode.createLinkedList(arr1, 3);
        lists[2] = ListNode.createLinkedList(arr2, 2);

        ListNode.printLinkedList(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode l : lists) {
            if (l != null) {
                queue.add(l);
            }
        }
        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            System.out.println(curr.val);
            head.next = curr;
            head = head.next;
            if (curr.next != null) {
                queue.add(curr.next);
            }
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void printLinkedList(ListNode head) {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + " -> ");
            curNode = curNode.next;
        }
        System.out.println("null");
    }

    public static ListNode createLinkedList(int[] arr, int n) {
        if (n == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;

        for (int i = 1; i < n; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }
}
