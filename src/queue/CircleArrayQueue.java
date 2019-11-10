package queue;

import java.util.Scanner;

/**
 * 队列（先进先出）
 * @Author HYStar
 * @Date 2019/11/7 13:36
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        //最大有效数据为3
        CircleQueue circleQueue = new CircleQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):取出数据");
            System.out.println("h(head):查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    circleQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleQueue.getQueue();
                        System.out.println("取出的数据是:" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleQueue.headQueue();
                        System.out.println("取出的数据是:" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}

/**
 * 使用数组模拟队列
 */
class CircleQueue {
    //表示数组最大容量
    private int maxSize;

    //队列头
    private int front;

    //队列尾
    private int rear;

    //该数据用于存放数据，模拟队列
    private int[] arr;

    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满了
    public boolean isFull() {
        System.out.println("rear==="+rear);
        System.out.println("f==="+front);
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满了
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列是空的");
        }
        int value = arr[front];
        //front后移
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue() {
        //判断队列是否是空的
        if (isEmpty()) {
            System.out.println("队列是空的");
            return;
        }
        //从front开始遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //获取有效数据个数
    public int size() {
        // rear = 2
        // maxSize = 3
        // front = 1
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据，不是取出
    public int headQueue() {
        //判断队列是否是空的
        if (isEmpty()) {
            throw new RuntimeException("队列是空的");
        }
        return arr[front];
    }
}