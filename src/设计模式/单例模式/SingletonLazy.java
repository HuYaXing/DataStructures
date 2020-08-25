package 设计模式.单例模式;

/**
 * 单例模式之懒汉式
 * 有线程安全问题
 * @Author HYStar
 * @Date 2020/8/14 16:22
 */
public class SingletonLazy {

    //需要对象的时候再创建
    private static final SingletonLazy instance = null;

    //私有化构造器，防止外界创建
    private SingletonLazy() {

    }

    //外界获取对象的方法
    public SingletonLazy getInstance(){
        if (instance == null){
            return new SingletonLazy();
        }
        return instance;
    }

}
