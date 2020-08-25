package 设计模式.简单工厂模式;

/**
 * @Author HYStar
 * @Date 2020/8/6 21:53
 */
public class Operation {

    private double _numberA = 0;
    private double _numberB = 0;

    public double get_numberA() {
        return _numberA;
    }

    public void set_numberA(double _numberA) {
        this._numberA = _numberA;
    }

    public double get_numberB() {
        return _numberB;
    }

    public void set_numberB(double _numberB) {
        this._numberB = _numberB;
    }

    public double GetResult() throws Exception {
        double result = 0;
        return result;
    }

}

class OperationAdd extends Operation{

    @Override
    public double GetResult() {
        double result = 0;
        result = get_numberA() + get_numberB();
        return result;
    }

}

class OperationSub extends Operation{

    @Override
    public double GetResult() {
        double result = 0;
        result = get_numberA() - get_numberB();
        return result;
    }

}

class OperationMul extends Operation{

    @Override
    public double GetResult() {
        double result = 0;
        result = get_numberA() * get_numberB();
        return result;
    }

}

class OperationDiv extends Operation{

    @Override
    public double GetResult() throws Exception {
        double result = 0;
        if (get_numberB() == 0){
            throw new Exception("除数不能为0");
        }
        result = get_numberA() / get_numberB();
        return result;
    }

}
