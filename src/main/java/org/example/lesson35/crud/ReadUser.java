package org.example.lesson35.crud;

import org.example.lesson35.model.User;
import org.example.lesson35.util.PostgresUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for getting user from database
 * It uses the "PostgresUtil" class to connect to the database.
 */
public class ReadUser {

    /**
     * Gets user from database.
     */
    public User getUser(int id) throws SQLException {
        PostgresUtil postgresUtil = PostgresUtil.getInstance();
        Connection connection = PostgresUtil.getConnection();

        PreparedStatement preparedStatement = null;
        ResultSet preparedResultSet = null;

        String sqlQuery = "SELECT * FROM users WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            preparedResultSet = preparedStatement.executeQuery();

            if (preparedResultSet.next()) {
                return new User(preparedResultSet.getInt("id"), preparedResultSet.getString("email"), preparedResultSet.getString("login"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception!!!");

        } finally {
            if (preparedResultSet != null) {
                preparedResultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }
}
