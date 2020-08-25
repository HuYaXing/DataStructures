package ��ת�㷨����.���ұ�;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author HYStar
 * @Date 2020/4/14 15:47
 */
public class ������ {

    public static void main(String[] args) {
        ������ a = new ������();
        int n = 10;
        System.out.println(a.isHappy(n));
    }

    public static boolean isHappy1(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = squareNum(n);
        }
        return n == 1;
    }



    static Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        int size = set.size();
        set.add(n);
        //����ѭ��
        if (size == set.size()) {
            return false;
        }
        int square = squareNum(n);
        if (square == 1) {
            return true;
        } else {
            return isHappy(square);
        }
    }

    public static int squareNum(int n) {
        if (n < 10) {
            return n * n;
        }
        return (n % 10) * (n % 10) + squareNum(n / 10);
    }
}
