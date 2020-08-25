package 蓝桥杯备战.JavaB组2016年;

/**
 * @Author HYStar
 * @Date 2020/5/27 9:13
 */
public class 煤球数目01 {

    public static void main(String[] args) {
        int res = 0;
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            res += i;
            ans += res;
        }
        System.out.println(ans);
    }

}
