package ua.company.model.dao.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Владислав on 05.09.2017.
 */
public class JDBCConnectionPool {
private Logger log = null;
    private String url;
    private String user;
    private String password;
    private int maxConn;


    private JDBCConnectionPool() {
        log = Logger.getRootLogger();



        this.url = "jdbc:mysql://localhost:3306/epamproject?autoReconnect=true&useSSL=false";
        this.user = "root";
        this.password = "root";
        this.maxConn = 10;

        loadDrivers();
    }

    private static JDBCConnectionPool instance;
    private ArrayList<Connection> freeConnections = new ArrayList<Connection>();

    public static synchronized JDBCConnectionPool getInstanceConnectionPool(){
        if (instance == null){
            return new JDBCConnectionPool();
        }
        return instance;
    }
    public synchronized Connection getConnection(){
        Connection connection = null;
        if (!freeConnections.isEmpty()){
            connection = freeConnections.get(freeConnections.size()-1);
            freeConnections.remove(connection);
            try{
                if (connection.isClosed()){
                  connection = getConnection();
                  log.debug("closed bad connection");
                }
            } catch (SQLException e) {
                log.debug("closed bad connection");
                connection = getConnection();
            }catch (Exception e) {
                log.debug("closed bad connection");
                connection = getConnection();
            }
        }else connection = newConnection();
    return connection;
    }
    private Connection newConnection(){
        Connection connection = null;
        try {
        if (user == null) {
            connection = DriverManager.getConnection(url);
        }
        else {
            connection = DriverManager.getConnection(url,user,password);
        }
            log.info("Created new connection "  +connection.toString());
        } catch (SQLException e) {
            log.error("Cant create connection fo this " + url);
            }
      return connection;
    }

    /**
     * @param connection
        Method put connection to the end of list if its possible;
     */
    public synchronized void freeConnection(Connection connection){
        if (connection != null && freeConnections.size()<maxConn){
            freeConnections.add(connection);
        }
    }

    /**
     * Method use iterator for getting connections and to close everyone;
     */
    public synchronized void released(){
        Iterator allConnections = freeConnections.iterator();
        while (allConnections.hasNext()){
            Connection connection = (Connection) allConnections.next();

            try {
                connection.close();
                log.info("Closed connection" + connection.toString());
            } catch (SQLException e) {
                log.error("Cant close connection");
            }
        }
        freeConnections.clear();
    }



    private void loadDrivers() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            log.info("Downloaded mysql.jdbc.Driver.");
        } catch (InstantiationException e) {
            log.error("Error in downloading mysql driver " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            log.info("Driver registered in Driver Manager.");
        } catch (Exception e) {
            log.error("Cant register jdbc driver.");
        }
    }

}
