package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import models.User;
import util.Const;


@WebServlet(name="loginServlet", value = {"/userLogin"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User();
        if(email.equals("canayakin93@gmail.com") && password.equals("")){
            System.out.println("giris yapildi");
            resp.sendRedirect(Const.base+"/dashboard.jsp");
            //RequestDispatcher dispatcher = req.getRequestDispatcher(Const.base+"/dashboard.jsp");
            System.out.println(23);
            //dispatcher.forward(req, resp);
        }else{
            req.setAttribute("error","E-mail and password doesn't match to any account.");
        }
    }
}
