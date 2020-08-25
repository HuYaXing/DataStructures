package leetcode����.ѧ��˼;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1 {


    /*������������������ʵ����ĿҪ��Ĺ���
    ��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^
    ******************************��ʼд����******************************/
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

    /******************************����д����******************************/


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
