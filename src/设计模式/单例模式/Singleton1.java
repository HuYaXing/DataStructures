package 设计模式.单例模式;

/**
 * @Author HYStar
 * @Date 2020/8/14 16:48
 */
public class Singleton1 {

    private static class SingletonHolder {
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    private Singleton1() {
    }

    public static final Singleton1 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
