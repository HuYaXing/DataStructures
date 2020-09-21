package LRU�������;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/8/13 22:50
 */
public class LRU {

    public static void main(String[] args) {
        LRU cache = new LRU(1 /* �������� */);

        cache.put(2, 1);
        // ����  1
        System.out.println(cache.get(2));
        // �ò�����ʹ�ùؼ��� 2 ����
        cache.put(3, 2);
        // ���� -1 (δ�ҵ�)
        System.out.println(cache.get(2));
        // ���� 2
        System.out.println(cache.get(3));
    }


    private final int MAX_SIZE;
    private Entry first;
    private Entry last;

    private HashMap<Integer, Entry> hashMap;

    public void put(int key, int value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            entry = new Entry();
            entry.key = key;
            if (hashMap.size() == MAX_SIZE) {
                removeLast();
            }
        }
        entry.value = value;
        movetoFirst(entry);
        hashMap.put(key, entry);
    }

    public int get(int key) {
        Entry entry = getEntry(key);
        if (entry == null) {
            return -1;
        }
        movetoFirst(entry);
        return entry.value;
    }

    public void remove(int key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            if (entry.next != null) {
                entry.next.pre = entry.pre;
            }
            if (entry.pre != null) {
                entry.pre.next = entry.next;
            }
            if (entry == first) {
                first = first.next;
            }
            if (entry == last) {
                last = last.pre;
            }
        }
    }

    public void removeLast() {
        hashMap.remove(last.key);
        if (last != null) {
            last = last.pre;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
        }
    }

    public void movetoFirst(Entry entry) {
        if (entry == first) {
            return;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry == last) {
            last = last.pre;
        }
        //��ӵ�һ��Ԫ�ص�ʱ����Ҫ
        if (first == null || last == null) {
            first = last = entry;
            return;
        }
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    public Entry getEntry(int key) {
        return hashMap.get(key);
    }

    public LRU(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        hashMap = new HashMap<>();
    }


    class Entry {
        public Entry pre;
        public Entry next;

        public int key;
        public int value;
    }

}
