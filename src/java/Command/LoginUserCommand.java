/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DAO.UserDao;
import DTO.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author D00194667
 */
public class LoginUserCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && !username.equals("") && !password.equals("")) {
            try {
                UserDao userDao = new UserDao("gsw");
                User u = userDao.login(username, password);

                if (u != null && u.getActive() == 1) {
                    HttpSession session = request.getSession();

                    session.setAttribute("numLogin", u);

                    forwardToJsp = "index.jsp";

                } else if (u != null && u.getActive() == 2) {
                    forwardToJsp = "error.jsp";
                    HttpSession session = request.getSession();
                    session.setAttribute("errorMessage", "You account has been disabled");

                } else {
                    forwardToJsp = "error.jsp";
                    HttpSession session = request.getSession();
                    session.setAttribute("errorMessage", "Incorrect Username or Password");

                }

            } catch (NullPointerException e) {
                forwardToJsp = "error.jsp";
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", "There is a null pointer Exception");
            }

        } else {
            forwardToJsp = "error.jsp";

            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "A parameter value required for login was missing");
        }
        return forwardToJsp;
    }
}
