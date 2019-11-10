package linkedlist;

/**
 * @Author HYStar
 * @Date 2019/11/9 11:24
 */
public class Josephus {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,2,5);

        circleSingleLinkedList.showBoy();
    }

}

//����һ�����εĵ�������
class CircleSingleLinkedList {
    //����һ��first�ڵ�
    private Boy first = new Boy(-1);

    //���С���ڵ�
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums��ֵ����ȷ��");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            //���ݱ�Ŵ���С���ڵ�
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                //���ɻ�
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                //���ӵ���һ���ڵ�
                boy.setNext(first);
                //
                curBoy = boy;
            }
        }
    }

    //����
    public void showBoy() {
        //�Ƿ�Ϊ��
        if (first == null) {
            System.out.println("Ϊ�գ�����");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println("���Ϊ��" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * �����û������룬�������Ȧ��˳��
     *
     * @param startNo  �ڼ���С����ʼ
     * @param countNum ������
     * @param nums     ����ɼ���С��
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //�ȶ����ݽ���Ч��
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("��˶Բ�����");
            return;
        }
        Boy helper = first;
        //ʹ��helperָ�����һ���ڵ�
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //����֮ǰ������first��helper�ƶ�k-1��
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //��������ʱ����first��helperͬʱ�ƶ�m-1��
        while(true){
            //��ʱȦ��ֻ��һ��Ԫ��
            if(helper == first){
                break;
            }
            //��first��helper�ƶ�countNum-1��
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //��ʱfirstָ��ĳ�Ȧ��С��
            System.out.println("��Ȧ"+first.getNo());
            //��Ȧ
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("����Ȧ��"+first.getNo());
        //��Ȧ
        first = first.getNext();
        helper.setNext(first);
    }

}

//����һ��Boy�࣬��ʾһ���ڵ�
class Boy {
    private int no;
    //ָ����һ���ڵ�
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
