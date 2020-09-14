package leetcode竞赛.八月;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/8/28 下午12:41
 */
public class 机器人能否返回原点 {
    public static void main(String[] args) {

    }

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            } else if (c == 'U') {
                y++;
            } else {
                y--;
            }
        }
        return x == 0 && y == 0;
    }
}
