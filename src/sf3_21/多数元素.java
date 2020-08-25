package sf3_21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author HYStar
 * @Date 2020/3/21 20:39
 */
public class ¶àÊıÔªËØ {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);

        for (int num : nums) {
            map.merge(num, 1, (newValue, oldValue) -> newValue + oldValue);
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if ((Integer) entry.getValue() > len / 2) {
                return (Integer) entry.getKey();
            }
        }
        return -1;
    }

    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }


}
