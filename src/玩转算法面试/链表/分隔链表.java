package 玩转算法面试.链表;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/18 22:28
 */
public class 分隔链表 {

    public static void main(String[] args) {
//        int[] arr = {1, 4, 3, 2, 5, 2};
//        ListNode head = ListNode.createLinkedList(arr,6);
//        ListNode.printLinkedList(head);
//        ListNode listNode = partition(head,3);
//        ListNode.printLinkedList(listNode);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            System.out.println(item);
            if ("3".equals(item)){
                list.remove(item);
//                iterator.remove();

                System.out.println("删除");
            }
        }
        System.out.println(list);
    }

    public static ListNode partition(ListNode head, int x) {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.get(1);
//        linkedHashMap.
        return null;
    }
}
