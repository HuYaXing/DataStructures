package leetcode竞赛.七月.sf7_24;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/7/24 23:18
 */
public class 从尾到头打印链表 {

    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res[i] = list.get(index);
            index++;
        }
        return res;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}