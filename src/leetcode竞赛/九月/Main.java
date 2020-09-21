package leetcode¾ºÈü.¾ÅÔÂ;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author     £ºhuyaxing
 * @date       £ºCreated in 2020/9/15 ÏÂÎç1:12
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 5000; i++) {
            if (i == 3937){
                System.out.println("000000");
            }
            String[] strs = sc.nextLine().split("\t");
            if (strs[0].length() != 32){
                System.out.println(strs[0]);
                break;
            }
            if (set.contains(strs[0])){
                System.out.println(strs[0]);
                break;
            }
            set.add(strs[0]);
        }
        System.out.println(set.size());
//        System.out.println(set);
    }


}
