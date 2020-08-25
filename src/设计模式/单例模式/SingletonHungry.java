package 设计模式.单例模式;

/**
 * 单例模式之饿汉式
 * 如果暂时不需要的话，就会对资源造成浪费
 * @Author HYStar
 * @Date 2020/8/14 16:17
 */
public class SingletonHungry {

    //在加载的时候，就创建对象
    private final static SingletonHungry instance = new SingletonHungry();

    //私有化构造器，防止外界创建
    private SingletonHungry() {

    }

    //外界获取对象的方法
    public static SingletonHungry getInstance() {
        return instance;
    }

}
