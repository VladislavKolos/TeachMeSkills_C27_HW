package org.example.lesson35.crud;

import org.example.lesson35.model.User;
import org.example.lesson35.util.PostgresUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for creating a new user in the database
 * It uses the "PostgresUtil" class to connect to the database.
 */
public class CreateUser {

    /**
     * Creates a new user in the database.
     */
    public void createUser(User user) throws SQLException {
        PostgresUtil postgresUtil = PostgresUtil.getInstance();
        Connection connection = PostgresUtil.getConnection();
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = null;

        String sqlQuery = "INSERT INTO users (id, email, login) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
            System.out.println("Exception!!!");

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            connection.setAutoCommit(true);
            connection.close();
        }
    }
}
