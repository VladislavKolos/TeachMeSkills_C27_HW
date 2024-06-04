package org.example.lesson35.crud;

import org.example.lesson35.util.PostgresUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for removing a user from the database
 * It uses the "PostgresUtil" class to connect to the database.
 */
public class DeleteUser {

    /**
     * Removes a user from the database.
     */
    public void deleteUser(int id) throws SQLException {
        PostgresUtil postgresUtil = PostgresUtil.getInstance();
        Connection connection = PostgresUtil.getConnection();
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = null;

        String sqlQuery = "DELETE FROM users WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
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
