package leetcode¾ºÈü.ÆßÔÂ·Ý;

/**
 * @Author HYStar
 * @Date 2020/7/20 9:50
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){

    }

    private Singleton getSingleton(){
        if (singleton != null){
            synchronized(Singleton.class){
                if (singleton != null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
