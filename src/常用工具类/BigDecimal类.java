package 常用工具类;

import java.math.BigDecimal;

/**
 * @Author HYStar
 * @Date 2020/5/11 16:36
 */
public class BigDecimal类 {

    public static void main(String[] args) {
        //double精度不够高
        double d1 = 2;
        double d2 = 1.2;
        double d3 = 1.1;
        //输出0.8
        System.out.println(d1 - d2);
        //输出0.8999999999999999
        System.out.println(d1 - d3);

        //解决方案，使用BigDecimal
        BigDecimal b1 = new BigDecimal("2");
        BigDecimal b2 = new BigDecimal("1.2");

        //比较,a = -1,表示b1小于b2；
        //a = 0,表示b1等于b2；
        //a = 1,表示b1大于b2；
        int a = b1.compareTo(b2);

        //加减乘除
        System.out.println(b1.add(b2));
        System.out.println(b1.subtract(b2));
        System.out.println(b1.multiply(b2));
//        System.out.println(b1.divide(b2,BigDecimal.ROUND_HALF_DOWN).toPlainString().substring(0,100));

        //使用double构建有一定的不可预知性
        BigDecimal a2 = new BigDecimal(Double.toString(0.1));
        //0.1000000000000000055511151231257827021181583404541015625
        System.out.println("a values is:" + a2);
        System.out.println("=====================");
        BigDecimal b = new BigDecimal("0.1");
        System.out.println("b values is:" + b);


    }

}
