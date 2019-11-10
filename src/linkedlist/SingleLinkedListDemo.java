package linkedlist;

import java.util.Stack;

/**
 * @Author HYStar
 * @Date 2019/11/8 17:23
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "张三", "111");
        HeroNode heroNode2 = new HeroNode(2, "李四", "222");
        HeroNode heroNode3 = new HeroNode(3, "王五", "333");
        HeroNode heroNode4 = new HeroNode(4, "赵六", "444");
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

    //获取单链表的节点个数
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

    //查找倒数第K个节点
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

    //将链表反转
    public static void reverseList(HeroNode head) {
        //若果为空或者只有一个节点
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode temp = head.next;
        //指向当前节点的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while(temp != null){
            //将下一个节点之后保存起来
            next = temp.next;
            //将temp的下一个节点指向新链表的最前端
            temp.next = reverseHead.next;
            //将temp连接到新的链表上
            reverseHead.next = temp;
            //将temp后移（将刚才存起来的节点赋值回去）
            temp = next;
        }
        head.next = reverseHead.next;

    }

    //利用栈实现逆序打印
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;
        }
        //创建一个节点
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
    //初始化一个头结点,不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到最后
    public void add(HeroNode heroNode) {
        //head不能动，需要一个辅助遍历temp
        HeroNode temp = head;

        //找到链表的最后
        while (true) {
            //找到了
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //按编号插入数据
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        //添加的编号是否存在
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
            System.out.println("编号存在！");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点信息
    public void update(HeroNode newHeroNode) {
        //是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;

        //是否找到该节点
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
            System.out.println("没有找到编号为" + newHeroNode.no + "的数据");
        }
    }

    //删除节点
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                System.out.println("到达最后！");
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

//定义一个HeroNode，一个对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    //指向下一个节点
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