package leetcode����.����.sf7_29;

import java.util.HashMap;

/**
 * @Author HYStar
 * @Date 2020/7/29 23:31
 */
public class ��������ĸ��� {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>(); //����HashMap����
        Node cur = head;
        //���ƽ��ֵ
        while (cur != null) {
            //�洢put:<key,value1>
            map.put(cur, new Node(cur.val)); //˳��������洢�Ͻ����½��(�ȴ洢�´����Ľ��ֵ)
            cur = cur.next;
        }
        //���ƽ��ָ��
        cur = head;
        while (cur != null) {
            //�õ�get:<key>.value2,3
            map.get(cur).next = map.get(cur.next); //�½��nextָ��ͬ�ɽ���nextָ��
            map.get(cur).random = map.get(cur.random); //�½��randomָ��ͬ�ɽ���randomָ��
            cur = cur.next;
        }

        //���ظ��Ƶ�����
        return map.get(head);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}