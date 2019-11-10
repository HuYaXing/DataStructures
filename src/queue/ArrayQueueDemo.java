package queue;

import java.util.Scanner;

/**
 * @Author HYStar
 * @Date 2019/11/6 20:15
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show):��ʾ����");
            System.out.println("e(exit):�˳�����");
            System.out.println("a(add):������ݵ�����");
            System.out.println("g(get):ȡ������");
            System.out.println("h(head):�鿴����ͷ����");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("���һ����");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("ȡ����������:"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("ȡ����������:"+res);
                    }catch (Exception e){
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
class ArrayQueue {
    //��ʾ�����������
    private int maxSize;

    //����ͷ
    private int front;

    //����β
    private int rear;

    //���������ڴ�����ݣ�ģ�����
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //ָ�����ͷ��������ͷǰһ��λ��
        front = -1;
        //ָ�����β
        rear = -1;
    }

    //�ж϶����Ƿ���
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++;
        arr[rear] = n;
    }

    //��ȡ��������
    public int getQueue() {
        //�ж϶����Ƿ�Ϊ��
        if (isEmpty()) {
            throw new RuntimeException("�����ǿյ�");
        }
        //front����
        front++;
        return arr[front];
    }

    //��ʾ������������
    public void showQueue() {
        //�ж϶����Ƿ��ǿյ�
        if (isEmpty()) {
            System.out.println("�����ǿյ�");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //��ʾ���е�ͷ���ݣ�����ȡ��
    public int headQueue() {
        //�ж϶����Ƿ��ǿյ�
        if (isEmpty()) {
            throw new RuntimeException("�����ǿյ�");
        }
        return arr[front + 1];
    }
}