package 蓝桥杯备战.JavaB组2015年;

/**
 * @Author HYStar
 * @Date 2020/5/24 9:47
 */
public class 立方变自身02 {

    public static void main(String[] args) {
        for (int i = 1; i < 10000; i++) {
            int a = i * i * i;
            int b = 0;
            while (a != 0) {
                b += a % 10;
                a /= 10;
            }
            if (b == i){
                System.out.println(i);
            }
        }
    }

}
