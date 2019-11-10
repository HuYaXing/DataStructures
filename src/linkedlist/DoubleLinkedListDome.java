package linkedlist;

/**
 * @Author HYStar
 * @Date 2019/11/9 8:44
 */
public class DoubleLinkedListDome {

    public static void main(String[] args) {
        Node node1 = new Node(1, "����");
        Node node2 = new Node(2, "����");
        Node node3 = new Node(3, "����");
        Node node4 = new Node(4, "����");
//        Node node5 = new Node(4, "XXXXXXX");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node2);

        doubleLinkedList.list();
    }

}

//����˫������
class DoubleLinkedList {
    //��ʼ��һ��ͷ���,����ž�������
    private Node head = new Node(0, "");

    //��ӽڵ㵽���
    public void add(Node node) {
        //head���ܶ�����Ҫһ����������temp
        Node temp = head;

        //�ҵ���������
        while (true) {
            //�ҵ���
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //����Ų�������
    public void addByOrder(Node node) {
        Node temp = head;
        //��ӵı���Ƿ����
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("��Ŵ��ڣ�");
        } else {
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;
            temp.next.pre = node;
        }
    }

    //�޸Ľڵ���Ϣ
    public void update(Node newNode) {
        //�Ƿ�Ϊ��
        if (head.next == null) {
            System.out.println("����Ϊ�գ�");
            return;
        }
        Node temp = head.next;

        //�Ƿ��ҵ��ýڵ�
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newNode.name;
        } else {
            System.out.println("û���ҵ����Ϊ" + newNode.no + "������");
        }
    }

    //ɾ���ڵ�
    public void delete(int no) {
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("�������");
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //���������⣿��������һ������Ҫִ��
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
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
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


//����һ��HeroNode��һ���������һ���ڵ�
class Node {
    public int no;
    public String name;
    //ָ����һ���ڵ�
    public Node next;
    //ָ����һ���ڵ�
    public Node pre;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

}