package ���ģʽ.����ģʽ;

/**
 * ����ģʽ֮����ʽ
 * �����ʱ����Ҫ�Ļ����ͻ����Դ����˷�
 * @Author HYStar
 * @Date 2020/8/14 16:17
 */
public class SingletonHungry {

    //�ڼ��ص�ʱ�򣬾ʹ�������
    private final static SingletonHungry instance = new SingletonHungry();

    //˽�л�����������ֹ��紴��
    private SingletonHungry() {

    }

    //����ȡ����ķ���
    public static SingletonHungry getInstance() {
        return instance;
    }

}
