package ���ű���ս.JavaB��2017��;

/**
 * @Author HYStar
 * @Date 2020/5/29 20:16
 */
public class ȡ��λ05 {

    static int len(int x) {
        if (x < 10) {
            return 1;
        }
        return len(x / 10) + 1;
    }


    // ȡx�ĵ�kλ����
    static int f(int x, int k) {
        if (len(x) - k == 0) {
            return x % 10;
        }
        //���
        return f(x / 10, k);
    }


    public static void main(String[] args) {
        int x = 23513;
//        System.out.println(len(x));
        System.out.println(f(x, 4));
    }

}
