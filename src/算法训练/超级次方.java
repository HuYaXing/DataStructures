package 算法训练;

/**
 * @Author HYStar
 * @Date 2019/11/22 20:19
 */
public class 超级次方 {

    public static void main(String[] args) {
        int[] b = {1,2};
        System.out.println(superPow(-2,b));
    }

    public static int superPow(int a, int[] b) {
        int rst = 1;
        int ten_power = 0, len = b.length, i_power = 0;
        if (a == 1) {
            return a;
        }
        a = a % 1337;
        ten_power = a;

        for (int i = b.length - 1; i >= 0; i--) {
            i_power = binaryPow(ten_power, b[i]);
            rst = (rst * i_power) % 1337;
            ten_power = binaryPow(ten_power, 10);
        }
        return rst;

    }

    public static int binaryPow(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int h = binaryPow(a, n / 2);
        if (n % 2 == 0) {
            return (h * h) % 1337;
        } else {
            // 此处务必两次mod，因为h*h*a的话，以最坏情况1336^3计算，是会超过Integer.MAX_VALUE的
            return ((h * h) % 1337) * a % 1337;
        }
    }

}
