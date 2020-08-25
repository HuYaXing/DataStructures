package leetcode¾ºÈü.°ËÔÂ.sf8_23;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2020/8/23 21:31
 */
public class tenxun2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int num = sc.nextInt();
        HashSet<String> set = new HashSet<>();
        PriorityQueue<String> queue = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
        for (int i = 1; i < str.length()+1 ; i++) {
            for (int j = 0; j < i ; j++) {
                String s = str.substring(j, i);
                if (queue.size() < num && !set.contains(s)){
                    queue.offer(s);
                    set.add(s);
                }else if (queue.peek().compareTo(s) > 0){
                    if (!set.contains(s)){
                        queue.poll();
                        queue.offer(s);
                        set.add(s);
                    }
                }
            }
        }

        System.out.println(queue.peek());
    }

}
