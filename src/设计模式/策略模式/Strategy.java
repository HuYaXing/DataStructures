package ���ģʽ.����ģʽ;

/**
 * �����㷨��
 *
 * @Author HYStar
 * @Date 2020/8/6 22:54
 */
abstract class Strategy {

    //�㷨����
    public abstract void AlgorithmInterface();

}

class ConcreteStrategyA extends Strategy {

    @Override
    public void AlgorithmInterface() {
        System.out.println("�㷨Aʵ��");
    }

}

class ConcreteStrategyB extends Strategy {

    @Override
    public void AlgorithmInterface() {
        System.out.println("�㷨Bʵ��");
    }

}

class ConcreteStrategyC extends Strategy {

    @Override
    public void AlgorithmInterface() {
        System.out.println("�㷨Cʵ��");
    }

}

class Context {

    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void ContextInterface(){
        strategy.AlgorithmInterface();
    }
}