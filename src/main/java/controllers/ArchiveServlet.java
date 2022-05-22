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

@WebServlet(name = "archiveServlet", value = {"/archivedItems"})
public class ArchiveServlet extends HttpServlet {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = sessionFactory.openSession();

        //check if there is an updated item
        String iid = req.getParameter("iid");
        if( iid != null ){
            try{
                int itemId = Integer.parseInt(iid);
                Transaction transaction = session.beginTransaction();
                Item item = session.load(Item.class, itemId);
                session.delete(item);
                transaction.commit();
            } catch ( Exception e ){

            }
        }

        List<Item> archivedItems = session.createQuery("FROM Item WHERE status = 'ARCHIVED'").getResultList();
        req.setAttribute("archivedItems",archivedItems);
        session.close();
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/archivedItems.jsp");
        requestDispatcher.forward(req, resp);

    }
}
