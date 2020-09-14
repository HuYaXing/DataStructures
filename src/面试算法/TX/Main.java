package √Ê ‘À„∑®.TX;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/9/6 20:06
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ListNode listNode1 = new ListNode(0);
        ListNode cur1 = listNode1;
        for (int i = 0; i < N; i++) {
            cur1.next = new ListNode(sc.nextInt());
            cur1 = cur1.next;
        }
        listNode1 = listNode1.next;
        int M = sc.nextInt();
        ListNode listNode2 = new ListNode(0);
        ListNode cur2 = listNode2;
        for (int i = 0; i < M; i++) {
            cur2.next = new ListNode(sc.nextInt());
            cur2 = cur2.next;
        }
        listNode2 = listNode2.next;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val == listNode2.val) {
                System.out.print(listNode1.val + " ");
                listNode1 = listNode1.next;
                listNode2 = listNode2.next;
            } else if (listNode1.val < listNode2.val) {
                listNode2 = listNode2.next;
            }else {
                listNode1 = listNode1.next;
            }
        }
        while (listNode1 != null){
            System.out.print(listNode1 .val);
            listNode1 = listNode1.next;
        }
        while (listNode2 != null){
            System.out.print(listNode2 .val);
            listNode2 = listNode2.next;
        }
    }

}

class ListNode {

    ListNode next;

    int val;

    ListNode(int val) {
        this.val = val;
    }
}