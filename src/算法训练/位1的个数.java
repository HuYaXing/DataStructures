package �㷨ѵ��;

/**
 * @Author HYStar
 * @Date 2019/11/21 21:20
 */
public class λ1�ĸ��� {

    public static void main(String[] args) {
        System.out.println(hammingWeight((3)));
    }

    public static int hammingWeight(int n) {
        int res = 0;
        int mark = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mark) != 0) {
                res++;
            }
            mark <<= 1;
        }
        return res;
    }

}
