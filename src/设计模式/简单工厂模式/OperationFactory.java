package 设计模式.简单工厂模式;

/**
 * @Author HYStar
 * @Date 2020/8/6 22:00
 */
public class OperationFactory {

    public static void main(String[] args) throws Exception {
        Operation oper = OperationFactory.createOperate("/");
        oper.set_numberA(1);
        oper.set_numberB(0);
        System.out.println(oper.GetResult());
    }


    public static Operation createOperate(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
            default:
                break;
        }
        return oper;
    }

}
