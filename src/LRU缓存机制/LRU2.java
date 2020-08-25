package LRU»º´æ»úÖÆ;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/8/18 19:48
 */
public class LRU2<K, V> {
    private final int MAX_SIZE;
    private Entry first;
    private Entry last;

    Map<K, Entry<K, V>> hashMap;

    public LRU2(int size) {
        MAX_SIZE = size;
        hashMap = new HashMap<>();
    }

    public void put(K key, V value) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            if (hashMap.size() > MAX_SIZE) {
                hashMap.remove(last.key);
                removeLast();
            }
            entry = new Entry<>();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key, entry);
    }

    public V get(K key){
        Entry<K,V> entry = getEntry(key);
        if (entry == null){
            return null;
        }
        moveToFirst(entry);
        return entry.value;
    }

    public void remove(K key){
        Entry entry = getEntry(key);
        if (entry != null){
            if (entry.pre != null){
                entry.pre.next = entry.next;
            }
            if (entry.next != null){
                entry.next.pre = entry.pre;
            }
            if (entry == first){
                first = first.next;
            }
            if (entry == last){
                last = last.pre;
            }
        }
        hashMap.remove(key);
    }

    private void moveToFirst(Entry<K, V> entry) {
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

        if (last == null || first == null) {
            last = first = entry;
            return;
        }
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
        }


    }

    private Entry<K, V> getEntry(K key) {
        return hashMap.get(key);
    }

    class Entry<K, V> {
        public Entry pre;
        public Entry next;
        public K key;
        public V value;
    }
}
