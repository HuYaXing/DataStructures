package �㷨ѵ��;

/**
 * @Author HYStar
 * @Date 2019/12/7 15:46
 */
public class ���˵ļ����� {

    public static void main(String[] args) {
        System.out.println(brokenCalc(5, 8));
    }

    public static int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            //����
            if (Y % 2 == 1) {
                Y++;
            } else {
                //ż��
                Y /= 2;
            }
        }

        return ans + X - Y;
    }

}
