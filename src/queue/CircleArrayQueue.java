package queue;

import java.util.Scanner;

/**
 * ���У��Ƚ��ȳ���
 * @Author HYStar
 * @Date 2019/11/7 13:36
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        //�����Ч����Ϊ3
        CircleQueue circleQueue = new CircleQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):��ʾ����");
            System.out.println("e(exit):�˳�����");
            System.out.println("a(add):������ݵ�����");
            System.out.println("g(get):ȡ������");
            System.out.println("h(head):�鿴����ͷ����");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("���һ����");
                    int value = scanner.nextInt();
                    circleQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleQueue.getQueue();
                        System.out.println("ȡ����������:" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleQueue.headQueue();
                        System.out.println("ȡ����������:" + res);
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
        System.out.println("�����˳���");
    }
}

/**
 * ʹ������ģ�����
 */
class CircleQueue {
    //��ʾ�����������
    private int maxSize;

    //����ͷ
    private int front;

    //����β
    private int rear;

    //���������ڴ�����ݣ�ģ�����
    private int[] arr;

    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //�ж϶����Ƿ�����
    public boolean isFull() {
        System.out.println("rear==="+rear);
        System.out.println("f==="+front);
        return (rear + 1) % maxSize == front;
    }

    //�ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {
        return rear == front;
    }

    //������ݵ�����
    public void addQueue(int n) {
        //�ж϶����Ƿ�����
        if (isFull()) {
            System.out.println("��������");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //��ȡ��������
    public int getQueue() {
        //�ж϶����Ƿ�Ϊ��
        if (isEmpty()) {
            throw new RuntimeException("�����ǿյ�");
        }
        int value = arr[front];
        //front����
        front = (front + 1) % maxSize;
        return value;
    }

    //��ʾ������������
    public void showQueue() {
        //�ж϶����Ƿ��ǿյ�
        if (isEmpty()) {
            System.out.println("�����ǿյ�");
            return;
        }
        //��front��ʼ����
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //��ȡ��Ч���ݸ���
    public int size() {
        // rear = 2
        // maxSize = 3
        // front = 1
        return (rear + maxSize - front) % maxSize;
    }

    //��ʾ���е�ͷ���ݣ�����ȡ��
    public int headQueue() {
        //�ж϶����Ƿ��ǿյ�
        if (isEmpty()) {
            throw new RuntimeException("�����ǿյ�");
        }
        return arr[front];
    }
}