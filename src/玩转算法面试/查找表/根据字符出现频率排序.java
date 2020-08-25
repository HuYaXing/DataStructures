package 玩转算法面试.查找表;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/4/15 9:54
 */
public class 根据字符出现频率排序 {

    public static void main(String[] args) {
        String s = "tree";
        frequencySort(frequencySort(s));
    }

    public static String frequencySort(String s) {
        HashMap<Integer, String> map = new HashMap<>();
        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                char ch = (char) i;
                String str = map.get(freq[i]);
                // 字符出现次数相同, 进行拼接
                if (str != null) {
                    String strNew = str.concat(build(ch, freq[i]));
                    map.put(freq[i], strNew);
                } else {
                    map.put(freq[i], build(ch, freq[i]));
                }
            }
        }
        Integer[] keys = map.keySet().toArray(new Integer[]{});
        Arrays.sort(keys);
        StringBuilder sbl = new StringBuilder();
        for (int i = keys.length - 1; i >= 0; i--) {
            sbl.append(map.get(keys[i]));
        }
        return sbl.toString();
    }

    private static String build(char ch, int times) {
        String string = Character.toString(ch);
        StringBuilder res = new StringBuilder(string);
        int t = 1;
        while (t < times) {
            res.append(string);
            t++;
        }
        return res.toString();
    }

}
