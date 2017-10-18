package ua.company.model.dao.genericDAO;

import org.apache.log4j.Logger;
import ua.company.model.dao.connection.JDBCConnectionPool;
import ua.company.model.dao.connection.JDBCConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Абстрактный класс предоставляющий базовую реализацию CRUD операций с использованием JDBC.
 *
 * @param <T> тип объекта персистенции
 */
public abstract class AbstractJDBCDao<T> implements GenericDAO<T> {
    private Logger logger = Logger.getRootLogger();
    JDBCConnectionPool jdbcConnectionPool = JDBCConnectionPool.getInstanceConnectionPool();


    /**
     * @return returns sql statement as string for getting all elements 'SELECT * FROM [TABLE]'
     */
    public abstract String getSelectQuery();

    /**
     * @return returns sql statement as string for insert new note 'insert into [table] (column ...) values (?...)'
     */
    public abstract String getCreateQuery();

    /**
     * @return returns sql statement as string for updating elements 'update [table] set [column = ? ..,.] where id =?'
     */
    public abstract String getUpdateQuery();

    /**
     * @return returns sql statement as string for deleting rows'SELECT * FROM [TABLE]'
     */
    public abstract String getDeleteQuery();

    /**
     * @return returns sql statement as string for insert rows
     */
    public abstract String getInsertQuery();


    protected abstract List<T> parseResultSet(ResultSet rs);

    protected abstract void prepareStatemantForInsert(PreparedStatement statement, T object);

    protected abstract void prepareStatemantForDelete(PreparedStatement statement, T object);


    @Override
    public void insert(T object) {
        String query = getInsertQuery();
        Connection connection = null;
       PreparedStatement preparedStatement = null;
        try{
            connection = getConnectionFromPool();
            preparedStatement = connection.prepareStatement(query);
            prepareStatemantForInsert(preparedStatement, object);
            preparedStatement.executeUpdate();
            logger.info("Insert into db new object " + object.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("error in inserting of object" + e);
        }
        finally {
            closeResources(preparedStatement,connection);
        }
    }

    ;

    @Override
    public T getById(int key) {
        List<T> list = null;
        String sql_query = getSelectQuery();
        sql_query += " where id = ? ";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionFromPool();
            preparedStatement = connection.prepareStatement(sql_query);
            preparedStatement.setInt(1, key);
            resultSet = preparedStatement.executeQuery();
            list = parseResultSet(resultSet);

            if (list == null) return null;
            if (list.size() > 1) return null;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Cant search admin by Id " + key);
        }
        finally {
        closeResources(resultSet,preparedStatement,connection);
        }
        return list.iterator().next();
    }

    @Override
    public void update(T object) {

    }


    public List<T> getAll() {
        List<T> list = null;
        String sql = getSelectQuery();
        Connection connection= null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnectionFromPool();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            list = parseResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Cant get all admins " + e);
        }
        finally {
            closeResources(resultSet,preparedStatement,connection);
        }
        return list;
    }

    /**
     * Method which persist object
     *
     * @param object
     * @return
     */
    public void delete(T object) {
        Connection connection = null;
        try {
            connection = getConnectionFromPool();
            String sql = getDeleteQuery();
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected Connection getConnectionFromPool() {
        Connection connection = null;

        connection = jdbcConnectionPool.getConnection();
        logger.info("created connection: " + connection.toString());
         jdbcConnectionPool.freeConnection(connection);
        if (connection == null) {
            System.out.println("Cant recieve connection");
        }

        return connection;
    }
      protected void closeResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){
          try {
              if(resultSet != null){
                  resultSet.close();
              }
              if (preparedStatement != null) {
                  preparedStatement.close();
              }
              if (connection !=null) {
                  connection.close();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      protected void closeResources(PreparedStatement preparedStatement, Connection connection){
        try {
            if (preparedStatement !=null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
