package 设计模式.单例模式;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/1 下午5:11
 */
public class DBConnection {

    public static void main(String[] args) {
        DBConnection con1 = DataSourceEnum.DATASOURCE.getConnection();
        DBConnection con2 = DataSourceEnum.DATASOURCE.getConnection();
        System.out.println(con1 == con2);
    }

}
