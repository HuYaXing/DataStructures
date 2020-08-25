package ���ű���ս.JavaB��2013��;

/**
 * @Author HYStar
 * @Date 2020/5/11 19:41
 */
public class ��������05 {

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
        //��ҪԼ��
        if (k > 1) {
            ra /= k;
            rb /= k;
        }
    }

    // �ӷ�
    public Rational add(Rational x) {
        //���λ��
        return new Rational(ra * x.rb + rb * x.ra, rb * x.rb);
    }

    // �˷�
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