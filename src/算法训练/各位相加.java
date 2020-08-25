package 算法训练;

/**
 * @Author HYStar
 * @Date 2019/11/30 14:49
 */
public class 各位相加 {

    public static void main(String[] args) {
        System.out.println(addDigits(12));
    }

    public static int addDigits(int num) {
        int res = num % 9;
        if(num == 0){
            return 0;
        }else if(res == 0) {
            return 9;
        }
        return res;
    }
}
