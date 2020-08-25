package 蓝桥杯备战.JavaB组2013年;

/**
 * @Author HYStar
 * @Date 2020/5/11 19:41
 */
public class 有理数类05 {

    public static void main(String[] args) {
        Rational a = new Rational(1, 3);
        Rational b = new Rational(1, 6);
        Rational c = a.add(b);
        System.out.println(a + "+" + b + "=" + c);
    }

}

class Rational {

    private long ra;

    private long rb;

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


    public Rational(long a, long b) {
        ra = a;
        rb = b;
        long k = gcd(ra, rb);
        //需要约分
        if (k > 1) {
            ra /= k;
            rb /= k;
        }
    }

    // 加法
    public Rational add(Rational x) {
        //填空位置
        return new Rational(ra * x.rb + rb * x.ra, rb * x.rb);
    }

    // 乘法
    public Rational mul(Rational x) {
        return new Rational(ra * x.ra, rb * x.rb);
    }


    @Override
    public String toString() {
        if (rb == 1) {
            return "" + ra;
        }
        return ra + "/" + rb;
    }
}