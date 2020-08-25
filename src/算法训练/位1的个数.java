package 算法训练;

/**
 * @Author HYStar
 * @Date 2019/11/21 21:20
 */
public class 位1的个数 {

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
