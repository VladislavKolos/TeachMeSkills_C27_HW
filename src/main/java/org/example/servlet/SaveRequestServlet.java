package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet class to check the data sent by the form
 * to redirect to successful save page.
 */
@WebServlet("/save-request")
public class SaveRequestServlet extends HttpServlet {

    /**
     * A method that processes a GET-request to open a page containing a form for entering an application.
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/save-request.jsp").forward(req, res);
    }

    /**
     * A method that processes a POST-request to check the data sent by the form
     * if one of the fields not specified, the servlet redirects to the data entry page
     * if the fields are correct, the servlet redirects to successful save page.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String nickName = req.getParameter("nickName");
        String messageText = req.getParameter("messageText");

        if (email == null || email.isEmpty() || nickName == null || nickName.isEmpty() || messageText == null || messageText.isEmpty()) {
            resp.sendRedirect(req.getHeader("referer"));
        }

        req.setAttribute("email", email);
        req.setAttribute("nickName", nickName);
        req.setAttribute("messageText", messageText);
        req.getRequestDispatcher("/WEB-INF/successful-save.jsp").forward(req, resp);

    }
}
