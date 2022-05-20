package models;

import util.DB;
import util.Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserModel {

    public boolean userLogin(String email, String password, String remember, HttpServletRequest req, HttpServletResponse resp){
        boolean status = false;
        DB db = new DB();
        try{
            String sql = "select * from users where email = ? and password = ? ";
            PreparedStatement pS = db.connect().prepareStatement(sql);
            pS.setString(1,email);
            pS.setString(2, Utils.MD5(password));
            ResultSet rS = pS.executeQuery();
            status = rS.next();
            //user data
            if ( status ) {
                int uid = rS.getInt("uid");
                String name = rS.getString("name");
                //Session Create
                User user = new User(uid, name, email);
                req.getSession().setAttribute("user", user);

                if( remember != null ){
                    String data = uid+"_"+name+"_"+email;
                    data = data.replace(" ","+");
                    Cookie cookie = new Cookie("user", data);
                    cookie.setMaxAge(60*60*24);
                    resp.addCookie(cookie);
                }
            }
        } catch ( Exception e ) {
            System.err.println("User Login Error : " + e);
        } finally {
            db.close();
        }

        return status;
    }

}
