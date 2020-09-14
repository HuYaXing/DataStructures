package ≤‚ ‘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author £∫huyaxing
 * @date £∫Created in 2020/9/8 …œŒÁ10:48
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = (ArrayList<Integer>) Arrays.asList(1, 2, 3);
        arrayList.add(4);
//        System.arraycopy();
        List<String> list = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);
//        CopyOnWriteArrayList
//        Test test = new Test() {
//            @Override
//            public void func1() {
//                System.out.println("----");
//            }
//        };
//        test.func2();
//        Test1 test1 = new Test1();
//        test.func1();
//        test.func2();
    }

}
