package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import models.User;
import models.UserModel;
import util.Const;


@WebServlet(name="loginServlet", value = {"/userLogin", "/userLogout"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = new UserModel();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        if(userModel.userLogin(email, password, remember, req, resp)){
            resp.sendRedirect(Const.base+"dashboard.jsp");
        }else{
            req.setAttribute("error","E-mail and password doesn't match to any account.");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //session remove
        req.getSession().removeAttribute("user");

        //cookie remove
        Cookie cookie = new Cookie("user","");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        resp.sendRedirect(Const.base);
    }
}
