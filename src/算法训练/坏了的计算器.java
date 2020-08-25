package 算法训练;

/**
 * @Author HYStar
 * @Date 2019/12/7 15:46
 */
public class 坏了的计算器 {

    public static void main(String[] args) {
        System.out.println(brokenCalc(5, 8));
    }

    public static int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            //奇数
            if (Y % 2 == 1) {
                Y++;
            } else {
                //偶数
                Y /= 2;
            }
        }

        return ans + X - Y;
    }

}
