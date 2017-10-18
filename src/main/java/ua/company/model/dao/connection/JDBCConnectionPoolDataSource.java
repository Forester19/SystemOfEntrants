package ua.company.model.dao.connection;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Владислав on 16.10.2017.
 */
public class JDBCConnectionPoolDataSource {
    private static DataSource dataSource;
    private static Logger logger = Logger.getRootLogger();
    public static int connectionCount;

    private JDBCConnectionPoolDataSource() {
    }
    public static DataSource getDataSource(){
        return dataSource;
    }


    static {
        try {
           Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/epamproject");
            logger.info("Created instance of DataSource ");
        } catch (Exception e) {
        logger.error("Cant create instance of DataSource ");
        }
    }
    public synchronized static Connection getConnection() throws SQLException {
        connectionCount++;
        return dataSource.getConnection();
    }
}
