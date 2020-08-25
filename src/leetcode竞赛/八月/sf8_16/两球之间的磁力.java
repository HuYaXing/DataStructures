package leetcode����.����.sf8_16;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author HYStar
 * @Date 2020/8/16 10:49
 */
public class ����֮��Ĵ��� {

    public static void main(String[] args) {
        ����֮��Ĵ��� main = new ����֮��Ĵ���();
        int[] position = {4875,3575,1216,9095,3488,8992,487,1764,8149,7054,4556,6637,1097,4337,4573,2355,5859,5874,1222,3110,8757,306,2234,8104,8638,5236,7534,5097,3182};

        System.out.println(main.maxDistance(position, 28));
    }

    public int maxDistance1(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int l = 1;
        int r = (position[n-1] - position[0]) / (m - 1);
        while(l < r){
            //mid����ǰ��С����
            int mid = l + (r - l + 1) / 2;
            //��������������֮��ľ���>=mid�ĸ���
            int cnt = 1;
            //ѡ�˵�һ����
            int last = position[0];
            for(int i = 1; i < n; i++){
                if(position[i] - last >= mid){
                    last = position[i];
                    cnt++;
                }
            }
            if(cnt >= m){
                //mid�Ƿ��ϵģ�midҲ���Ը������Ž����Ұ�����
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }



    boolean[] memo;
    int n;
    int ans = Integer.MIN_VALUE;

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        n = m;
        memo = new boolean[position.length];
        f(position, new ArrayList<>(), 0);
        return ans;
    }

    private void f(int[] position, ArrayList<Integer> nums, int index) {
        if (nums.size() == n) {
            int min = minNum(nums);
            ans = Math.max(min, ans);
            return;
        }
        if (nums.size() + position.length - index + 1 < n){
            return;
        }
        for (int i = index; i < position.length; i++) {
            if (!memo[i]) {
                memo[i] = true;
                nums.add(position[i]);
                f(position, nums, i);
                memo[i] = false;
                nums.remove(nums.size() - 1);
            }
        }
    }

    private int minNum(ArrayList<Integer> nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            min = Math.min(min, Math.abs(nums.get(i + 1) - nums.get(i)));
        }
        return min;
    }


}
