package leetcode竞赛.十月.sf10_10;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/10/10 下午4:04
 */
public class MedianFinder {

    public static void main(String[] args) {
        Queue<Integer> A = new PriorityQueue<>();
        A.add(9);
        A.add(10);
        A.add(1);
        System.out.println(A.poll());
    }

    Queue<Integer> A, B;

    public MedianFinder() {
        // 小顶堆，保存较大的一半
        A = new PriorityQueue<>();
        // 大顶堆，保存较小的一半
        B = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }

}
