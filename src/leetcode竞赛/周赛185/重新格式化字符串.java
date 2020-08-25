package leetcode竞赛.周赛185;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/19 10:31
 */
public class 重新格式化字符串 {

    public static void main(String[] args) {
        String s = "ab123";
        System.out.println(reformat(s));
    }

    public static String reformat(String s) {
        if (s.length() <= 1){
            return s;
        }
        List<Character> nums = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                chars.add(s.charAt(i));
            } else {
                nums.add(s.charAt(i));
            }
        }

        if (Math.abs(chars.size() - nums.size()) >= 2) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        if(chars.size() > nums.size()){
            for (int i = 0; i < nums.size(); i++) {
                sb.append(chars.get(i));
                sb.append(nums.get(i));
            }
            sb.append(chars.get(chars.size() - 1));
        }else if(chars.size() < nums.size()) {
            for (int i = 0; i < chars.size(); i++) {
                sb.append(nums.get(i));
                sb.append(chars.get(i));
            }
            sb.append(nums.get(nums.size() - 1));
        }else {
            for (int i = 0; i < nums.size(); i++) {
                sb.append(chars.get(i));
                sb.append(nums.get(i));
            }
        }
        return sb.toString();
    }
}
