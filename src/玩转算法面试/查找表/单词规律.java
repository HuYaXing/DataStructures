package 玩转算法面试.查找表;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/4/14 18:04
 */
public class 单词规律 {

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map = new HashMap<>();
        String[] array = str.split(" ");
        if(array.length != pattern.length()){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            if(map.containsKey(key)){
                if(!map.get(key).equals(array[i])){
                    return false;
                }
            }else {
                if(map.containsValue(array[i])){
                    return false;
                }
                map.put(key,array[i]);
            }
        }
        return true;
    }
}
