package leetcode����.����.sf7_30;

/**
 * @Author HYStar
 * @Date 2020/7/30 23:04
 */
public class ��������1�ĸ��� {

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //�ɵ�λ���λ�ж�,>>����0������1��>>>��������0
            if (((n >>> i) & 1) == 1) {
                res++;
            }
        }
        return res;
    }

}
