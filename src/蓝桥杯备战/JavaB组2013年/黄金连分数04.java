package ���ű���ս.JavaB��2013��;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author HYStar
 * @Date 2020/5/11 11:11
 */
public class �ƽ�������04 {

    public static void main(String[] args) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        //��������ռ䣬ֱ��������ٱ仯
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
        //��������һλ��������
        System.out.println(divide.toPlainString().substring(0,103));
    }

}
