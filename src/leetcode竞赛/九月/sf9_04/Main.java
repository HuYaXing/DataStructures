package leetcode竞赛.九月.sf9_04;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/4 下午7:33
 */
public class Main implements Cloneable {

    public static void main(String[] args) {


        throw1();


        int a = 1;
        int b = 0;
        try {
            System.out.println("a/b的值是：" + a / b);
        } catch (ArithmeticException e) {
            System.out.println("-------------");
        }

        System.out.println("this will not be printed!");

        Main main = new Main();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        int[] s = {3, 2, 0, 3, 4};
//        Integer a = 2;
        dfs(a);
        System.out.println(a);
//        Object
//        System.out.println(main.drink(s, 5, 2));
    }

    static void throw1() {
        System.out.println("Inside throw1 . ");
        throw new NullPointerException("demo");
    }

    private static void dfs(Integer a) {
        short x = 1;
        x += 1;
        Integer b = 3;
        a = b.intValue();
    }

    public int drink(int[] s, int x, int y) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < s.length; i++) {
            int num = 0;
            for (int j = i; j < s.length; j++) {
                num += Math.min(s[j], y);
                if (num >= x && j - i < min) {
                    min = j - i;
                    res = i;
                }
            }
        }
        return res;
    }

}
