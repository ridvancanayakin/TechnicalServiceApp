package util;

import models.User;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Utils {

    public static void control(HttpServletRequest req){
        if( req.getCookies() != null ){
            for (Cookie item:req.getCookies()) {
                if( item.getName().equals("user")){
                    String val = item.getValue();
                    String[] arr = val.split("_");
                    int uid =Integer.parseInt(arr[0]);
                    String name = arr[1].replace("+"," ");
                    String email = arr[2];
                    User user = new User(uid, name, email);
                    req.getSession().setAttribute("user", user);
                    break;
                }
            }
        }

    }

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
