package ���ù�����;

import java.math.BigDecimal;

/**
 * @Author HYStar
 * @Date 2020/5/11 16:36
 */
public class BigDecimal�� {

    public static void main(String[] args) {
        //double���Ȳ�����
        double d1 = 2;
        double d2 = 1.2;
        double d3 = 1.1;
        //���0.8
        System.out.println(d1 - d2);
        //���0.8999999999999999
        System.out.println(d1 - d3);

        //���������ʹ��BigDecimal
        BigDecimal b1 = new BigDecimal("2");
        BigDecimal b2 = new BigDecimal("1.2");

        //�Ƚ�,a = -1,��ʾb1С��b2��
        //a = 0,��ʾb1����b2��
        //a = 1,��ʾb1����b2��
        int a = b1.compareTo(b2);

        //�Ӽ��˳�
        System.out.println(b1.add(b2));
        System.out.println(b1.subtract(b2));
        System.out.println(b1.multiply(b2));
//        System.out.println(b1.divide(b2,BigDecimal.ROUND_HALF_DOWN).toPlainString().substring(0,100));

        //ʹ��double������һ���Ĳ���Ԥ֪��
        BigDecimal a2 = new BigDecimal(Double.toString(0.1));
        //0.1000000000000000055511151231257827021181583404541015625
        System.out.println("a values is:" + a2);
        System.out.println("=====================");
        BigDecimal b = new BigDecimal("0.1");
        System.out.println("b values is:" + b);


    }

}
