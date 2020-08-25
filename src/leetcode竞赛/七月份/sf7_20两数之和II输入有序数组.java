package leetcode竞赛.七月份;

/**
 * @Author HYStar
 * @Date 2020/7/20 8:30
 */
public class sf7_20两数之和II输入有序数组 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] res = new int[2];
        while(start < end){
            int num = numbers[start] + numbers[end];
            if(num == target){
                res[0] = start + 1;
                res[1] = end + 1;
                return res;
            }else if(num < target){
                start++;
            }else{
                end--;
            }
        }
        return res;
    }
}
