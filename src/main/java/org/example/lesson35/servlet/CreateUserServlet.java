package org.example.lesson35.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lesson35.model.User;
import org.example.lesson35.service.UserService;

import java.io.IOException;
import java.sql.SQLException;

/**
 * This servlet class processes requests to create a new user
 * It contains GET and POST methods.
 */
@WebServlet("/create")
public class CreateUserServlet extends HttpServlet {
    private final UserService userService;

    public CreateUserServlet() {
        userService = new UserService();
    }

    /**
     * Processes GET-requests
     * Sends a request to a JSP-page to create a new user.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/create_user.jsp").forward(req, resp);
    }

    /**
     * Processes POST-requests
     * Processes the form submission to create a new user.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idAsLine = req.getParameter("id");
        String email = req.getParameter("email");
        String login = req.getParameter("login");

        if (idAsLine == null || idAsLine.isEmpty()
                || email == null || email.isEmpty()
                || login == null || login.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/create");
        }

        try {
            if (idAsLine != null) {
                int id = Integer.parseInt(idAsLine);

                User user = User.builder()
                        .id(id)
                        .email(email)
                        .login(login)
                        .build();

                userService.createUser(user);
                resp.sendRedirect(req.getContextPath() + "/get?id=" + user.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
