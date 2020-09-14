package LRU»º´æ»úÖÆ;

import java.util.HashMap;
import java.util.Map;

public class LRUA<K, V> {

    private int MAX_SIZE;
    private Entry<K, V> first;
    private Entry<K, V> last;

    Map<K, Entry<K, V>> map;

    public LRUA(int size) {
        this.MAX_SIZE = size;
        this.map = new HashMap<>();
    }


    public void put(K key, V value) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            if (map.size() > MAX_SIZE) {
                map.remove(last.key);
                removeLast();
            }
            entry = new Entry<>();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        map.put(key, entry);
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
        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            if (entry.pre != null) {
                entry.pre.next = entry.next;
            }
            if (entry.next != null) {
                entry.next.pre = entry.pre;
            }
            if (entry == first) {
                first = first.next;
            }
            if (entry == last) {
                last = last.pre;
            }
        }
        map.remove(key);
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
        return map.get(key);
    }

    class Entry<K, V> {
        public Entry<K, V> pre;
        public Entry<K, V> next;
        public K key;
        public V value;
    }

}
