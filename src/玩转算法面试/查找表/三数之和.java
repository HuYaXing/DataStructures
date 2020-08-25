package 玩转算法面试.查找表;

import java.util.*;

/**
 * @Author HYStar
 * @Date 2020/1/16 21:23
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] nums = {-1, -1, 2};
        System.out.println(threeSum(nums));
    }

    /**
     * 方法一 暴力解法
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int l = 0;
        int r = nums.length - 1;
        if (r < 2) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[r] < 0) {
            return result;
        } else if (nums[0] == 0 && nums[r] == 0) {
            list.add(0);
            list.add(0);
            list.add(0);
            result.add(list);
            return result;
        }
        for (int i = 0; i <= r - 2; i++) {
            for (int j = i + 1; j <= r - 1; j++) {
                for (int k = j + 1; k <= r; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        list = new ArrayList<>();
                    }
                    while (k < r && nums[k] == nums[k + 1]) {
                        k++;
                    }
                }
                while (j < r && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < r && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    /**
     * 方法二
     * 多指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || len < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;

            int min1 = nums[i] + nums[left] + nums[left + 1];
            if (min1 > 0) {
                break;
            }
            int max1 = nums[i] + nums[len - 1] + nums[len - 2];
            if (max1 < 0) {
                continue;
            }

            while (left < right) {
                int num = nums[i] + nums[left] + nums[right];
                if (num == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (num < 0) {
                    left++;
                } else if (num > 0) {
                    right--;
                }
            }

        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        //考虑3个0的情况
        if (map.containsKey(0) && map.get(0) >= 3) {
            addToListList(0, 0, 0, listList);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) * 2 + list.get(j) == 0 && map.get(list.get(i)) >= 2) {
                    addToListList(list.get(i), list.get(i), list.get(j), listList);
                }
                if (list.get(i) + list.get(j) * 2 == 0 && map.get(list.get(j)) >= 2) {
                    addToListList(list.get(i), list.get(j), list.get(j), listList);
                }
                int num = -list.get(i) - list.get(j);
                if (num > list.get(j) && map.containsKey(num)) {
                    addToListList(list.get(i), list.get(j), num, listList);
                }
            }
        }
        return listList;
    }

    private void addToListList(int num1, int num2, int num3, List<List<Integer>> listList) {
        List<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        listList.add(list);
    }

}
