package org.example.lesson35.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lesson35.crud.CreateUser;
import org.example.lesson35.model.User;

import java.io.IOException;
import java.sql.SQLException;

/**
 * This servlet class processes requests to create a new user
 * It contains GET and POST methods.
 */
@WebServlet("/create")
public class CreateUserServlet extends HttpServlet {
    private final CreateUser createUser = new CreateUser();

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

        if (idAsLine == null || idAsLine.isEmpty() || email == null || email.isEmpty() || login == null || login.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/create");
        }

        try {
            if (idAsLine != null) {
                int id = Integer.parseInt(idAsLine);

                User user = new User();
                user.setId(id);
                user.setEmail(email);
                user.setLogin(login);

                createUser.createUser(user);
                req.setAttribute("user", user);
                req.getRequestDispatcher("/WEB-INF/user_info.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
