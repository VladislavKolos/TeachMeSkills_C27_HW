package org.example.lesson35.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lesson35.crud.UpdateUser;

import java.io.IOException;
import java.sql.SQLException;

/**
 * This servlet class processes requests to change the login of an existing user
 * It contains GET and POST methods.
 */
@WebServlet("/change-login")
public class ChangeLoginServlet extends HttpServlet {
    private final UpdateUser updateUser = new UpdateUser();

    /**
     * Processes GET-requests
     * Sends a request to a JSP-page to change the user's login.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/change_user_login.jsp").forward(req, resp);
    }

    /**
     * Processes POST-requests
     * Processes the form submission to change the login of an existing user.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idAsLine = req.getParameter("id");
        String email = req.getParameter("email");
        String newLogin = req.getParameter("login");

        if (idAsLine == null || idAsLine.isEmpty() || email == null || email.isEmpty() || newLogin == null || newLogin.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/change-login");
        }

        try {
            if (idAsLine != null) {
                int id = Integer.parseInt(idAsLine);

                updateUser.updateUser(id, email, newLogin);
                resp.sendRedirect(req.getContextPath() + "/get?id=" + id + "&login=" + newLogin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
