package org.example.lesson35.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lesson35.service.UserService;

import java.io.IOException;
import java.sql.SQLException;

/**
 * This servlet class processes requests to delete users from the database
 * t contains GET and POST methods.
 */
@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    private final UserService userService;

    public DeleteUserServlet() {
        userService = new UserService();
    }

    /**
     * Processes GET-requests
     * Sends a request to a JSP-page to delete users from the database.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/delete_user.jsp").forward(req, resp);
    }

    /**
     * Processes POST-requests
     * Processes the form submission to delete users from database.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idAsLine = req.getParameter("id");

        if (idAsLine == null || idAsLine.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/delete");
        }

        try {
            if (idAsLine != null) {
                int id = Integer.parseInt(idAsLine);

                userService.deleteUser(id);
                resp.sendRedirect(req.getContextPath() + "/delete");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
