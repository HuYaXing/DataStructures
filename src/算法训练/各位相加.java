package �㷨ѵ��;

/**
 * @Author HYStar
 * @Date 2019/11/30 14:49
 */
public class ��λ��� {

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
