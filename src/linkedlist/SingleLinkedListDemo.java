package linkedlist;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2019/11/8 17:23
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "����", "111");
        HeroNode heroNode2 = new HeroNode(2, "����", "222");
        HeroNode heroNode3 = new HeroNode(3, "����", "333");
        HeroNode heroNode4 = new HeroNode(4, "����", "444");
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);

        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);

//        reverseList(singleLinkedList.getHead());

        singleLinkedList.list();

        reversePrint(singleLinkedList.getHead());
//        System.out.println(findLastIndexNode(singleLinkedList.getHead(), 2));


//        singleLinkedList.delete(4);

//        singleLinkedList.list();
    }

    //��ȡ������Ľڵ����
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //���ҵ�����K���ڵ�
    public static HeroNode findLastIndexNode(HeroNode head, int k) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (k <= 0 || k > size) {
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //������ת
    public static void reverseList(HeroNode head) {
        //����Ϊ�ջ���ֻ��һ���ڵ�
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode temp = head.next;
        //ָ��ǰ�ڵ����һ���ڵ�
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while(temp != null){
            //����һ���ڵ�֮�󱣴�����
            next = temp.next;
            //��temp����һ���ڵ�ָ�����������ǰ��
            temp.next = reverseHead.next;
            //��temp���ӵ��µ�������
            reverseHead.next = temp;
            //��temp���ƣ����ղŴ������Ľڵ㸳ֵ��ȥ��
            temp = next;
        }
        head.next = reverseHead.next;

    }

    //����ջʵ�������ӡ
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;
        }
        //����һ���ڵ�
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

}

class SingleLinkedList {
    //��ʼ��һ��ͷ���,����ž�������
    private HeroNode head = new HeroNode(0, "", "");

    //��ӽڵ㵽���
    public void add(HeroNode heroNode) {
        //head���ܶ�����Ҫһ����������temp
        HeroNode temp = head;

        //�ҵ���������
        while (true) {
            //�ҵ���
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //����Ų�������
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        //��ӵı���Ƿ����
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("��Ŵ��ڣ�");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //�޸Ľڵ���Ϣ
    public void update(HeroNode newHeroNode) {
        //�Ƿ�Ϊ��
        if (head.next == null) {
            System.out.println("����Ϊ�գ�");
            return;
        }
        HeroNode temp = head.next;

        //�Ƿ��ҵ��ýڵ�
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("û���ҵ����Ϊ" + newHeroNode.no + "������");
        }
    }

    //ɾ���ڵ�
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                System.out.println("�������");
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println(no + "��Ų����ڣ���");
        }
    }

    //��������
    public void list() {
        //�ж��Ƿ�Ϊ��
        if (head.next == null) {
            System.out.println("Ϊ�գ�");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public HeroNode getHead() {
        return head;
    }
}

//����һ��HeroNode��һ���������һ���ڵ�
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    //ָ����һ���ڵ�
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

}