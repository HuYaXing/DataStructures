package leetcode����.ʮ��.sf10_9;

/**
 * @author ��huyaxing
 * @date ��Created in 2020/10/9 ����2:19
 */
public class ������ {

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
