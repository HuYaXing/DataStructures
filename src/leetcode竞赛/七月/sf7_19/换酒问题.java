package leetcode����.����.sf7_19;

/**
 * @Author HYStar
 * @Date 2020/7/19 10:30
 */
public class �������� {

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
        System.out.println(numWaterBottles(15, 4));
        System.out.println(numWaterBottles(5, 5));
        System.out.println(numWaterBottles(2, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            ans += numBottles / numExchange;
            numBottles = numBottles % numExchange + numBottles / numExchange;
        }
        return ans;
    }
}
