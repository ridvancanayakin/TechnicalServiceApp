package controllers;

import models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.Const;
import util.HibernateUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "itemServlet", value = {"/item","/addItem"})
public class ItemServlet extends HttpServlet {
    SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = sf.openSession();

        //check if there is an updated item
        String iid = req.getParameter("iid");
        if( iid != null ){
            try{
                int itemId = Integer.parseInt(iid);
                Transaction transaction = session.beginTransaction();
                Item item = session.load(Item.class, itemId);
                if ( req.getParameter("archive") != null ) {
                    item.setStatus(Const.Status.ARCHIVED);
                    session.update(item);
                } else {
                    session.delete(item);
                }

                transaction.commit();
            } catch ( Exception e ){

            }
        }
        // get the item list
        List<Item> items = session.createQuery("FROM Item WHERE status != 'ARCHIVED' and status != 'DELETEDs'").getResultList();
        req.setAttribute("items", items);
        session.close();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String info = req.getParameter("info");

        Item item = new Item();
        item.setTitle(title);
        item.setInfo(info);
        item.setStatus(Const.Status.ACCEPTED);

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(item);
        transaction.commit();
        session.close();

        resp.sendRedirect(Const.base+"item");

    }
}
