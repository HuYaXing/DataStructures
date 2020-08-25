package sf3_21;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/3/21 20:59
 */
public class 求众数II {

    public static void main(String[] args) {

    }

    //暴力
    public static List<Integer> majorityElement0(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.merge(num, 1, (newValue, oldValue) -> newValue + oldValue);
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if ((Integer) entry.getValue() > len / 3) {
                list.add((Integer) entry.getKey());
            }
        }
        return list;
    }

    //摩尔投票法
    public static List<Integer> majorityElement(int[] nums) {
        int one = nums[0];
        int tow = nums[0];
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (one == num) {
                count1++;
                continue;
            }
            if (tow == num) {
                count2++;
                continue;
            }

            if (count1 == 0) {
                one = num;
                continue;
            }
            if (count2 == 0) {
                tow = num;
                continue;
            }
            count1--;
            count2--;
        }
        List<Integer> list = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (one == num) {
                count1++;
            } else if (tow == num) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            list.add(one);
        }
        if (count2 > nums.length / 3) {
            list.add(tow);
        }
        return list;
    }
}
