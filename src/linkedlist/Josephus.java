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

//创建一个环形的单向链表
class CircleSingleLinkedList {
    //创建一个first节点
    private Boy first = new Boy(-1);

    //添加小孩节点
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确！");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                //构成环
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                //连接到第一个节点
                boy.setNext(first);
                //
                curBoy = boy;
            }
        }
    }

    //遍历
    public void showBoy() {
        //是否为空
        if (first == null) {
            System.out.println("为空！！！");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println("编号为：" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 根据用户的输入，计算出出圈的顺序
     *
     * @param startNo  第几个小孩开始
     * @param countNum 数几下
     * @param nums     最初由几个小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行效验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("请核对参数！");
            return;
        }
        Boy helper = first;
        //使得helper指向最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //报数之前，先让first和helper移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当报数的时候，让first和helper同时移动m-1次
        while(true){
            //此时圈中只有一个元素
            if(helper == first){
                break;
            }
            //让first和helper移动countNum-1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first指向的出圈的小孩
            System.out.println("出圈"+first.getNo());
            //出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后出圈的"+first.getNo());
        //出圈
        first = first.getNext();
        helper.setNext(first);
    }

}

//创建一个Boy类，表示一个节点
class Boy {
    private int no;
    //指向下一个节点
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
