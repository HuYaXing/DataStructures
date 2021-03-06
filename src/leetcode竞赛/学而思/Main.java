package leetcode竞赛.学而思;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/5/13 19:32
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int isReserveSame(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return 0;
            }
            start++;
            end--;
        }
        return 1;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int res;
        res = isReserveSame(s);
        System.out.println(String.valueOf(res));
    }
}
