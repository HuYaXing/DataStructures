package leetcode竞赛.五月.sf5_13;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

/**
 * @Author HYStar
 * @Date 2020/5/13 15:24
 */
public class 日期之间隔几天 {

    public static void main(String[] args) {

    }

    public int daysBetweenDates2(String date1, String date2) {
        return (int)Math.abs(LocalDate.parse(date1).until(LocalDate.parse(date2), ChronoUnit.DAYS));
    }

    public int daysBetweenDates(String date1, String date2) {
        Calendar beginCalendar = Calendar.getInstance();
        String[] year1 = date1.split("-");
        beginCalendar.set(Calendar.YEAR, Integer.parseInt(year1[0]));
        beginCalendar.set(Calendar.MONTH, Integer.parseInt(year1[1]) - 1);
        beginCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(year1[2]));

        Calendar endCalendar = Calendar.getInstance();
        String[] year2 = date2.split("-");
        endCalendar.set(Calendar.YEAR, Integer.parseInt(year2[0]));
        endCalendar.set(Calendar.MONTH, Integer.parseInt(year2[1]) - 1);
        endCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(year2[2]));

        long beginTime = beginCalendar.getTimeInMillis();
        long endTime = endCalendar.getTimeInMillis();
        //先算出两时间的毫秒数之差大于一天的天数
        return Math.abs((int) ((endTime - beginTime) / (1000 * 60 * 60 * 24)));
    }


    int[] _365M = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates1(String date1, String date2) {
        int[] dates1 = parseDate(date1), dates2 = parseDate(date2);
        return Math.abs(calculateDays(dates1[0], dates1[1], dates1[2]) - calculateDays(dates2[0], dates2[1], dates2[2]));
    }

    int calculateDays(int year, int month, int day) {
        int dayC1 = day - 1;
        for (int i = month; i > 1; i--) {
            dayC1 += _365M[i - 1 - 1];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month > 2) {
            dayC1++;
        }
        dayC1 += (365 * (year - 1) + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400);
        return dayC1;
    }

    int[] parseDate(String date) {
        return new int[]{Integer.valueOf(date.substring(0, 4)), Integer.valueOf(date.substring(5, 7)), Integer.valueOf(date.substring(8, 10))};
    }

}
