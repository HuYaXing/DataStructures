package 蓝桥杯备战.JavaB组2013年;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author HYStar
 * @Date 2020/5/11 11:11
 */
public class 黄金连分数04 {

    public static void main(String[] args) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        //增大运算空间，直到结果不再变化
        for (int i = 3; i < 500; i++) {
            BigInteger temp = b;
            b = a.add(b);
            a = temp;
        }
//        System.out.println("a" + a.toString());
//        System.out.println("b" + b.toString());

        BigDecimal a1 = new BigDecimal(a,110);
        BigDecimal b1 = new BigDecimal(a,110);

        System.out.println("a" + a1.toString());
        System.out.println("b" + b1.toString());

        BigDecimal divide = new BigDecimal(a,110).divide(new BigDecimal(b,110),BigDecimal.ROUND_HALF_DOWN);
        //结果将最后一位四舍五入
        System.out.println(divide.toPlainString().substring(0,103));
    }

}
