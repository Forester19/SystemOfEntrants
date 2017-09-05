package ua.company.epam.dao.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

/**
 * Created by Владислав on 05.09.2017.
 */
public class JDBCConnectionPool {
    private String url;
    private String user;
    private String password;
    private int maxConn;


    private JDBCConnectionPool() {
        this.url = "jdbc:mysql://localhost:3306/epamproject";
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
                    System.out.println("closed bad connection");
                }
            } catch (SQLException e) {
                System.out.println("closed bad connection");
                connection = getConnection();
            }catch (Exception e) {
                System.out.println("closed bad connection");
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
            System.out.println("Created new connection!");
        } catch (SQLException e) {
            System.out.println("Cant create connection fo this " + url);
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
                System.out.println("Closed connection");
            } catch (SQLException e) {
                System.out.println("Cant close connection");
            }
        }
        freeConnections.clear();
    }



    private void loadDrivers() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (Exception e) {
            System.out.println("Cant register jdbc driver.");
        }
    }

}
