package leetcode����.����.sf8_26;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/8/26 ����2:21
 */
public class Test {

    public static void main(String[] args) {
        Date d = new Date();
        Calendar no = Calendar.getInstance();
        no.setTime(d);
        no.set(Calendar.DATE, no.get(Calendar.DATE) - 1);
        Date date = no.getTime();
        System.out.println(Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(date)));
    }

}
