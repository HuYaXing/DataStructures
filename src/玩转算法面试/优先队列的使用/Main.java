package ��ת�㷨����.���ȶ��е�ʹ��;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author HYStar
 * @Date 2020/4/24 16:15
 */
public class Main {

    //�Զ���Ƚ���
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer e1, Integer e2) {
            return e2 - e1;
        }
    };
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>();
        q.add(3);
        q.add(2);
        q.add(4);

        while (!q.isEmpty()){
            System.out.println(q.poll());
        }

        //ʹ�ñȽ���
        Queue<Integer> qq = new PriorityQueue<>(cmp);
        qq.add(3);
        qq.add(2);
        qq.add(4);
        while(!qq.isEmpty())
        {
            System.out.println(qq.poll());
        }


    }

}
