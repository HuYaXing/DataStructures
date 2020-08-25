package �㷨ѵ��;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @Author HYStar
 * @Date 2019/11/30 15:15
 */
public class ��ĸ��λ�ʷ��� {
    private static Map<Character, Integer> table = new HashMap<>();
    static {
        table.put('a', 2);
        table.put('b', 3);
        table.put('c', 5);
        table.put('d', 7);
        table.put('e', 11);
        table.put('f', 13);
        table.put('g', 17);
        table.put('h', 19);
        table.put('i', 23);
        table.put('j', 29);
        table.put('k', 31);
        table.put('l', 37);
        table.put('m', 41);
        table.put('n', 43);
        table.put('o', 47);
        table.put('p', 53);
        table.put('q', 59);
        table.put('r', 61);
        table.put('s', 67);
        table.put('t', 71);
        table.put('u', 73);
        table.put('v', 79);
        table.put('w', 83);
        table.put('x', 89);
        table.put('y', 97);
        table.put('z', 101);
    }
    public static void main(String[] args) {
//        String[] strs = {"ray","cod","abe","ned","arc","jar","owl","pop","paw","sky","yup","fed","jul","woo","ado","why","ben","mys","den","dem","fat","you","eon","sui","oct","asp","ago","lea","sow","hus","fee","yup","eve","red","flo","ids","tic","pup","hag","ito","zoo"};
//        System.out.println(groupAnagrams(strs));

    }

    //�ⷨһ
    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<Integer,List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            int a = 1;
            for (int j = 0; j < strs[i].length(); j++) {
                a *= table.get(strs[i].charAt(j));
            }
            if(!map.containsKey(a)){
                List<String> list = new LinkedList<>();
                list.add(strs[i]);
                map.put(a,list);
            }else{
                map.get(a).add(strs[i]);
            }
        }
        return new LinkedList<>(map.values());
    }

    //�ⷨ��
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<char[]> chars = new ArrayList<>();

        IntStream.range(0, strs.length).forEach(i -> {
            int flag = isNewString(chars, strs[i]);
            if (flag != -1) {
                res.get(flag).add(strs[i]);
            } else {
                chars.add(strs[i].toCharArray());
                List<String> newString = new ArrayList<>();
                newString.add(strs[i]);
                res.add(newString);
            }
        });
        return res;
    }

    //�ж��ַ��������Ƿ�����ͬ����,�������±�
    public static int isNewString(List<char[]> chars, String str) {
        char[] newChar = str.toCharArray();
        for (int i = 0; i < chars.size(); i++) {
            char[] charsOne = chars.get(i);
            if (newChar.length == charsOne.length) {
                if(isSameArray(newChar,charsOne)){
                    return i;
                }
            }
        }
        return -1;
    }

    //�ж����������Ƿ���ͬ
    public static boolean isSameArray(char[] array1,char[] array2){
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }
}
