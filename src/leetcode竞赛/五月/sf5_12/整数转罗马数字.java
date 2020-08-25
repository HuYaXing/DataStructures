package leetcode竞赛.五月.sf5_12;

/**
 * @Author HYStar
 * @Date 2020/5/12 21:51
 */
public class 整数转罗马数字 {

    public static void main(String[] args) {
        整数转罗马数字 main = new 整数转罗马数字();
        System.out.println(main.intToRoman(144));
    }

    private int[] nums =
            {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private String[] keys =
            {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
            for (int i = index; i < nums.length; i++) {
                if (num >= nums[i]) {
                    num -= nums[i];
                    sb.append(keys[i]);
                    index = i;
                    break;
                }
            }
        }
        return sb.toString();
    }

}
