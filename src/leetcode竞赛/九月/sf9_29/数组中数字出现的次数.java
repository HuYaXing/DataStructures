package leetcode����.����.sf9_29;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/9/29 ����8:09
 */
public class ���������ֳ��ֵĴ��� {

    public static int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] res = new int[2];
        Set<Integer> set = map.keySet();
        int index = 0;
        for (Integer key : set) {
            if (index == 2) {
                break;
            }
            if (map.get(key) == 1) {
                res[index] = key;
                index++;
            }
        }
        return res;
    }

    public static int[] singleNumbers1(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, zeroCount = 0;
        for (int num: nums) {
            if (num == 0) {
                zeroCount += 1;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum ^= num;
        }
        // ��Ҫ����һ��ĳ������0�������
        if (zeroCount == 1) {
            return new int[]{sum, 0};
        }
        int lo = min, hi = max;
        while (lo <= hi) {
            // ���� lo �����������ж϶���λ����ôд����ֹԽ�硣
            int mid = (lo < 0 && hi > 0)? (lo + hi) >> 1: lo + (hi - lo) / 2;
            int loSum = 0, hiSum = 0;
            for (int num: nums) {
                if (num <= mid) {
                    loSum ^= num;
                } else {
                    hiSum ^= num;
                }
            }
            if (loSum != 0 && hiSum != 0) {
                // ��������Ϊ0��˵�� p �� q �ֱ��䵽2���������ˡ�
                return new int[] {loSum, hiSum};
            }
            if (loSum == 0) {
                // ˵�� p �� q ���� mid �����Ա� mid С���������ͱ�Ϊ0�ˡ�
                lo = mid + 1;
            } else {
                // ˵�� p �� q �������� mid
                hi = mid - 1;
            }
        }
        // ��ʵ��������Ƿ���Ҫ��ģ����򲻻�ִ�е����Ϊ�˷�ֹcompile error��һ��
        return null;
    }


    public static void main(String[] args) {
        System.out.println(1/2);
        int[] nums = {4, 1, 6, 4};
        singleNumbers(nums);
    }
}
