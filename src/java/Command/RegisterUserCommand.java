/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import DAO.UserDao;
import DTO.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author D00194667
 */
public class RegisterUserCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forwardToJsp = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if (username != null && password != null && !username.equals("") && !password.equals("") && email != null && !email.equals("")) {

            UserDao userDao = new UserDao("gsw");
            int result = userDao.register(username, password, email);

            HttpSession session = request.getSession();

            session.setAttribute("numRegister", result);

       
            if (result > 0) {
                User u = userDao.getUserById(result);
                session.setAttribute("numLogin", u);
            }


            forwardToJsp = "registerSuccesful.jsp";
        } else {
            forwardToJsp = "error.jsp";

            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "A parameter value required for register was missing");
        }
        return forwardToJsp;

    }
}
