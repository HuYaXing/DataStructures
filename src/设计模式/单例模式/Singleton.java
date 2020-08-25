package 设计模式.单例模式;

/**
 * @Author HYStar
 * @Date 2020/8/14 16:46
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    public Singleton() {

    }

    public static Singleton getInstance(){
        if (uniqueInstance == null){
            synchronized (Singleton.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}
