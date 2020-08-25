package 蓝桥杯备战.JavaB组2013年;

import java.util.Calendar;

/**
 * @Author HYStar
 * @Date 2020/5/10 20:02
 */
public class 世纪末的星期01 {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        for (int i = 1999; i < 100000; i += 100) {
            calendar.set(Calendar.YEAR, i);
            //12月
            calendar.set(Calendar.MONTH, 11);
            calendar.set(Calendar.DAY_OF_MONTH, 31);
            int i1 = calendar.get(Calendar.DAY_OF_WEEK);
            if (i1 == 1){
                System.out.println(i);
                break;
            }
        }
    }

}
