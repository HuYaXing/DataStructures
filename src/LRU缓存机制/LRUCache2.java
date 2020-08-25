package LRU�������;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/4/12 8:40
 */
public class LRUCache2<K,V> extends LinkedHashMap<K,V> {

    private final int MAZ_CACHE_SIZE;

    public LRUCache2(int cacheSize){
        //������accessOrderΪtrueʱ�����ᰴ�շ���˳������������ʵķ�����ǰ��������ʵķ��ں���
        super((int) Math.ceil(cacheSize / 0.75) + 1,0.75f,true);
        MAZ_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAZ_CACHE_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

}
