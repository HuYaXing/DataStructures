package leetcode竞赛.十月.sf10_9;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/10/9 下午2:19
 */
public class 回文数 {

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x <= 0 || x % 10 == 0) {
            return false;
        }
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed == x || x == reversed / 10;
    }

}
