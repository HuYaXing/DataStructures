package LRU»º´æ»úÖÆ;

import Å£¿Í±ÊÊÔ.Main;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/8/14 8:36
 */
public class LRU1<K, V> {

    private Entry<K, V> first;
    private Entry<K, V> last;
    private final int MAX_SIZE;

    private HashMap<K, Entry<K, V>> hashMap;

    public LRU1(int cacheSize) {
        MAX_SIZE = cacheSize;
        hashMap = new HashMap<>();
    }

    public void put(K key, V value) {
        Entry<K, V> entry = getEntry(key);

        if (entry == null){
            if (hashMap.size() >= MAX_SIZE) {
                removeLast();
            }
            entry = new Entry<K, V>();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key, entry);
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        moveToFirst(entry);
        return entry.value;
    }

    public void remove(K key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            if (entry.pre != null) {
                entry.pre = entry.next;
            }
            if (entry.next != null) {
                entry.next = entry.pre;
            }
            if (entry == first) {
                first = first.next;
            }
            if (entry == last) {
                last = last.pre;
            }
        }
        hashMap.remove(key);
    }

    public void moveToFirst(Entry entry) {
        if (entry == first) {
            return;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (first == null || last == null) {
            first = last = entry;
            return;
        }
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    public Entry<K, V> getEntry(K key) {
        return hashMap.get(key);
    }

    public void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Entry entry = first;
        while (entry != null) {
            sb.append(String.format("%s:%s", entry.key, entry.value));
            entry = entry.next;
        }
        return sb.toString();
    }

    class Entry<K, V> {
        public Entry pre;
        public Entry next;
        public K key;
        public V value;
    }

}
