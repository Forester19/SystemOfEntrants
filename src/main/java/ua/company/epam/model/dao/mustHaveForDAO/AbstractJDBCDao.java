package ua.company.epam.model.dao.mustHaveForDAO;

import org.apache.log4j.Logger;
import ua.company.epam.model.dao.connection.JDBCConnectionPool;

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
    private JDBCConnectionPool jdbcConnectionPool;


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
        Connection connection = getConnectionFromPool();
        String query = getInsertQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            prepareStatemantForInsert(preparedStatement,object);
            preparedStatement.executeUpdate();
            logger.info("Insert into db new Admin " + object.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("error in inserting of admin " + e );
        }
    }

    ;

    @Override
    public T getById(int key) {

        Connection connection = getConnectionFromPool();
        List<T> list = null;
        String sql_query = getSelectQuery();
        sql_query += "where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql_query)) {
            preparedStatement.setInt(1, key);
            ResultSet rs = preparedStatement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Cant search admin by Id " + key);
        }

        if (list == null) return null;
        if (list.size() > 1) return null;
        return list.iterator().next();
    }

    @Override
    public void update(T object){

    };

    public List<T> getAll() {
        Connection connection = getConnectionFromPool();
        List<T> list = null;
        String sql = getSelectQuery();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            list = parseResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Cant get all admins " + e);
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
        Connection connection = getConnectionFromPool();
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Connection getConnectionFromPool() {
        Connection connection;
        jdbcConnectionPool = JDBCConnectionPool.getInstanceConnectionPool();
        connection = jdbcConnectionPool.getConnection();
        if (connection == null) {
            System.out.println("Cant recieve connection");
        }
        jdbcConnectionPool.freeConnection(connection);
    return connection;
    }

}
