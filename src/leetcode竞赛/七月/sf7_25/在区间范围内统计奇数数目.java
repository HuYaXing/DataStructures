package leetcode����.����.sf7_25;

/**
 * @Author HYStar
 * @Date 2020/7/25 22:30
 */
public class �����䷶Χ��ͳ��������Ŀ {

    public static void main(String[] args) {
        System.out.println();
    }

    public int countOdds(int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++) {
            if ((i & 1) != 0) {
                res++;
            }
        }
        return res;
    }
}
