package leetcode����.����;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/9/13 9:05
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1 /* �������� */);

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


    private Entry first;
    private Entry last;
    private HashMap<Integer, Entry> hashMap;

    final private int MAX_SIZE;

    public LRUCache(int capacity) {
        MAX_SIZE = capacity;
        hashMap = new HashMap<>();
    }

    public int get(int key) {
        Entry entry = getEntry(key);
        if (entry == null) {
            return -1;
        }
        movetoFirst(entry);
        return entry.value;
    }

    public void put(int key, int value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            entry = new Entry();
            if (hashMap.size() >= MAX_SIZE) {
                removeLast();
            }
            entry.key = key;
        }
        entry.value = value;
        hashMap.put(key, entry);
        movetoFirst(entry);
    }

    public void movetoFirst(Entry entry) {
        if (entry == first) {
            return;
        }
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (entry == last) {
            last = last.pre;
        }
        //��ʼ����ʱ��first��lastΪ��
        if (first == null || last == null) {
            first = last = entry;
            return;
        }
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    public void removeLast() {
        hashMap.remove(last.key);
        if (last != null) {
            last = last.pre;
            if (last == null) {
                first = null;
            }else {
                last.next = null;
            }
        }
    }

    public Entry getEntry(int key) {
        return hashMap.get(key);
    }

    class Entry {
        public int key;
        public int value;
        public Entry pre;
        public Entry next;
    }

}

