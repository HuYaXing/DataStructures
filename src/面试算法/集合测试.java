package �����㷨;

import java.util.*;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/4 ����10:25
 */
public class ���ϲ��� {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deque1 = new LinkedList<>();
        int xx = Integer.MIN_VALUE;
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10000000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            xx += arrayList.get(i);
        }
        System.out.println("��ͨforarrayList��ʱ��" + (System.currentTimeMillis() - startTime1));
        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < linkedList.size(); i++) {
//            xx += linkedList.get(i);
//        }
        System.out.println("��ͨforlinkedList��ʱ��" + (System.currentTimeMillis() - startTime));

        long startTime2 = System.currentTimeMillis();
        for (Integer itr : arrayList) {
            xx += itr;
        }
        System.out.println("��ǿforarrayList��ʱ��" + (System.currentTimeMillis() - startTime2));
        long startTime3 = System.currentTimeMillis();
        for (Integer itr : linkedList) {
            xx += itr;
        }
        System.out.println("��ǿforlinkedList��ʱ��" + (System.currentTimeMillis() - startTime3));

        long startTime4 = System.currentTimeMillis();
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            xx += next;
        }
        System.out.println("IteratorforarrayList��ʱ��" + (System.currentTimeMillis() - startTime4));
        long startTime5 = System.currentTimeMillis();
        Iterator<Integer> iterator1 = linkedList.iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            xx += next;
        }
        System.out.println("IteratorforlinkedList��ʱ��" + (System.currentTimeMillis() - startTime5));
    }

}
