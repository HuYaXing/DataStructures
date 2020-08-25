package leetcode竞赛.学而思;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int engthOfLongestSubstr(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char[] memo = new char[256];
                boolean flag = true;
                String temp = s.substring(i, j);
                for (int k = 0; k < temp.length(); k++) {
                    if (memo[s.charAt(k)] > 0) {
                        flag = false;
                        break;
                    }
                    memo[s.charAt(k)]++;
                }
                if (flag){
                    ans = Math.max(ans,temp.length());
                }
            }
        }
        return ans;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        res = engthOfLongestSubstr(_s);
        System.out.println(String.valueOf(res));
    }
}
