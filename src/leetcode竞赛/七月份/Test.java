package leetcode¾ºÈü.ÆßÔÂ·Ý;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/7/20 14:33
 */
public class Test {
    public static void main(String[] args) {
        List<T> list = new ArrayList<>();
        T t = new T();
        for (int i = 0; i < 10; i++) {
            t.i = i;
            list.add(t);
        }
        System.out.println(list);
    }
}

class T{
    Integer i;


    @Override
    public String toString() {
        return i.toString();
    }
}
