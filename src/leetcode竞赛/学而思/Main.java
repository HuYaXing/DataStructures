package leetcode����.ѧ��˼;

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


    /*������������������ʵ����ĿҪ��Ĺ���
    ��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^
    ******************************��ʼд����******************************/
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
    /******************************����д����******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int res;
        res = isReserveSame(s);
        System.out.println(String.valueOf(res));
    }
}
