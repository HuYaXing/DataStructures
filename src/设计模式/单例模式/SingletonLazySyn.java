package 设计模式.单例模式;

/**
 * @Author HYStar
 * @Date 2020/8/14 16:41
 */
public class SingletonLazySyn {

    private static final SingletonLazySyn instance = null;

    private SingletonLazySyn() {

    }

    public synchronized SingletonLazySyn getInstance(){
        if (instance == null){
            return new SingletonLazySyn();
        }
        return instance;
    }

}
