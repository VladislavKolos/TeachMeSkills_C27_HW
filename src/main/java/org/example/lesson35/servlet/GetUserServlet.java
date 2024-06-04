package org.example.lesson35.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lesson35.crud.ReadUser;
import org.example.lesson35.model.User;

import java.io.IOException;
import java.sql.SQLException;

/**
 * This servlet class processes requests to retrieve user information based on the user ID
 * It contains GET method.
 */
@WebServlet("/get")
public class GetUserServlet extends HttpServlet {
    private final ReadUser readUser = new ReadUser();

    /**
     * Processes GET-requests
     * Retrieves user information based on user ID and forwards the request to the "user_info.jsp" page.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            User user = readUser.getUser(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/user_info.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
