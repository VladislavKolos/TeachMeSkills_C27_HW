package org.example.service;

import org.example.model.User;
import org.example.util.PostgresUtil;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserService {
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

    public User getUser(int id) throws SQLException {
        PostgresUtil postgresUtil = PostgresUtil.getInstance();
        Connection connection = PostgresUtil.getConnection();

        PreparedStatement preparedStatement = null;
        ResultSet preparedResultSet = null;

        String sqlQuery = "SELECT * FROM users WHERE id = ?";

        User user = null;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            preparedResultSet = preparedStatement.executeQuery();

            if (preparedResultSet.next()) {
                user = User.builder()
                        .id(preparedResultSet.getInt("id"))
                        .email(preparedResultSet.getString("email"))
                        .login(preparedResultSet.getString("login"))
                        .build();
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
        return user;
    }

    public void updateUser(int id, String email, String newLogin) throws SQLException {
        PostgresUtil postgresUtil = PostgresUtil.getInstance();
        Connection connection = PostgresUtil.getConnection();
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = null;

        String sqlQuery = "UPDATE users SET login = ? WHERE id = ? AND email = ?";

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, newLogin);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, email);
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
