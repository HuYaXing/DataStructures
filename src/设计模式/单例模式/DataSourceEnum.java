package 设计模式.单例模式;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/1 下午5:10
 */
public enum DataSourceEnum {
    /**
     * lianjie
     */
    DATASOURCE;
    private DBConnection connection = null;

    private DataSourceEnum(){
        connection = new DBConnection();
    }

    public DBConnection getConnection(){
        return connection;
    }
}
