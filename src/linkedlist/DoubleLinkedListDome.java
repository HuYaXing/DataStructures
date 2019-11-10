package linkedlist;

/**
 * @Author HYStar
 * @Date 2019/11/9 8:44
 */
public class DoubleLinkedListDome {

    public static void main(String[] args) {
        Node node1 = new Node(1, "张三");
        Node node2 = new Node(2, "李四");
        Node node3 = new Node(3, "王五");
        Node node4 = new Node(4, "赵六");
//        Node node5 = new Node(4, "XXXXXXX");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node2);

        doubleLinkedList.list();
    }

}

//创建双向链表
class DoubleLinkedList {
    //初始化一个头结点,不存放具体数据
    private Node head = new Node(0, "");

    //添加节点到最后
    public void add(Node node) {
        //head不能动，需要一个辅助遍历temp
        Node temp = head;

        //找到链表的最后
        while (true) {
            //找到了
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //按编号插入数据
    public void addByOrder(Node node) {
        Node temp = head;
        //添加的编号是否存在
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
            System.out.println("编号存在！");
        } else {
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;
            temp.next.pre = node;
        }
    }

    //修改节点信息
    public void update(Node newNode) {
        //是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        Node temp = head.next;

        //是否找到该节点
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
            System.out.println("没有找到编号为" + newNode.no + "的数据");
        }
    }

    //删除节点
    public void delete(int no) {
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("到达最后！");
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
            //这里有问题？如果是最后一个不需要执行
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println(no + "编号不存在！！");
        }
    }

    //遍历链表
    public void list() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("为空！");
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


//定义一个HeroNode，一个对象就是一个节点
class Node {
    public int no;
    public String name;
    //指向下一个节点
    public Node next;
    //指向上一个节点
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