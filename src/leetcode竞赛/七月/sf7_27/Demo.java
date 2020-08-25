package leetcode¾ºÈü.ÆßÔÂ.sf7_27;

/**
 * @Author HYStar
 * @Date 2020/7/28 17:04
 */
class A {
    static int cnt = 0;

    static {
        System.out.println("a()");
    }

    int a = 1;

    A() {
        System.out.println("A()");
        System.out.println(cnt);
    }
}

class B extends A {
    static {
        System.out.println("b()");
    }

    int b = 10;

    B() {
        System.out.println("B()");
        cnt++;
        System.out.println(cnt);
    }
}

class C extends B {
    static {
        System.out.println("c()");
    }

    int c = 1000;

    C() {
        cnt++;
        System.out.println("C()");
        System.out.println(cnt);
    }
}

public class Demo {
    public static void main(String[] args) {
        C c1 = new C();
        System.out.println();
        B b1 = new B();
        System.out.println();
        A a1 = new A();
    }
}
