package ��ת�㷨����.�ݹ������;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author HYStar
 * @Date 2020/4/28 16:13
 */
public class ȫ���� {

    public static void main(String[] args) {
        ȫ���� main = new ȫ����();
        String[] nums = {"ʥ", "��", "��", "��"};
        System.out.println();
        List<List<String>> res = main.permute(nums);
        for (int i = 0; i < res.size(); i++) {
            List<String> temp = res.get(i);
            String str = "";
            for (int j = 0; j < temp.size(); j++) {
                str += temp.get(j);
            }
            System.out.println(str);
        }
    }

    List<List<String>> res = new LinkedList<>();
    boolean[] used;

    public List<List<String>> permute(String[] nums) {
        if (nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        generatePermutation(nums, 0, new LinkedList<>());
        return res;
    }

    public void generatePermutation(String[] nums, int index, List<String> p) {
        if (index == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                p.remove(index);
                used[i] = false;
            }
        }
    }
}
