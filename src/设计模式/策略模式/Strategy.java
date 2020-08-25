package 设计模式.策略模式;

/**
 * 抽象算法类
 *
 * @Author HYStar
 * @Date 2020/8/6 22:54
 */
abstract class Strategy {

    //算法方法
    public abstract void AlgorithmInterface();

}

class ConcreteStrategyA extends Strategy {

    @Override
    public void AlgorithmInterface() {
        System.out.println("算法A实现");
    }

}

class ConcreteStrategyB extends Strategy {

    @Override
    public void AlgorithmInterface() {
        System.out.println("算法B实现");
    }

}

class ConcreteStrategyC extends Strategy {

    @Override
    public void AlgorithmInterface() {
        System.out.println("算法C实现");
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