package hr.algebra.dao;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;

public class DataSourceSingleton {
    
    private static DataSource instance;
    private static final String SERVER_NAME = "localhost";
    private static final String DATABASE_NAME = "PPPK_PROJ";
    private static final String USER = "sas";
    private static final String PASSWORD = "SQL";
    private static final int PORT = 1433;

    private DataSourceSingleton(){}
    
    public static DataSource getInstance() {
        if (instance == null) {
            instance = createInstance();
        }
        return instance;
    }

    private static DataSource createInstance() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName(SERVER_NAME);
        dataSource.setDatabaseName(DATABASE_NAME);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setPortNumber(PORT);
        return dataSource;
    }    
}
