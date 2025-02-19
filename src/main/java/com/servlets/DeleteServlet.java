package com.servlets;

import com.entity.TODO;
import com.helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
//import java.io.PrintWriter;

public class DeleteServlet extends HttpServlet
{
private static final long serialVersionUID = 1L;
    public DeleteServlet()
    {
    super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {

        try {
             int noteId= Integer.parseInt(req.getParameter("note_id").trim());
            Session s1 = FactoryProvider.getFactory().openSession();
            Transaction tx = s1.beginTransaction();
            TODO todo  = (TODO)s1.get(TODO.class, noteId);
            s1.delete(todo);
            tx.commit();
            s1.close();
            resp.sendRedirect("all_notes.jsp");
        }
        catch (Exception e)
        {
        e.printStackTrace();
        }


    }
}
