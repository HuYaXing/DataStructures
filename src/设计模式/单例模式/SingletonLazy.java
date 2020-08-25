package ���ģʽ.����ģʽ;

/**
 * ����ģʽ֮����ʽ
 * ���̰߳�ȫ����
 * @Author HYStar
 * @Date 2020/8/14 16:22
 */
public class SingletonLazy {

    //��Ҫ�����ʱ���ٴ���
    private static final SingletonLazy instance = null;

    //˽�л�����������ֹ��紴��
    private SingletonLazy() {

    }

    //����ȡ����ķ���
    public SingletonLazy getInstance(){
        if (instance == null){
            return new SingletonLazy();
        }
        return instance;
    }

}
