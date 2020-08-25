package LRU»º´æ»úÖÆ;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author HYStar
 *
 * @Date 2020/4/12 8:40
 */
public class LRUCache {

    public static void main(String[] args) {
//        int a = 5;
//        int b = 4;
//
//        System.out.println(a & b);
//        System.out.println(a & (b - 1));
//        System.out.println(a % b);
//        System.out.println(a - (a / b) * b);

        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name1", "josan1");
        hashMap.put("name2", "josan2");
        hashMap.put("name3", "josan3");
        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }

}
