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
import java.util.Date;

public class UpdateServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public UpdateServlet()
    {
    super();
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
{
     try
     {
      String title=request.getParameter("title");
      String content=request.getParameter("content");
      int noteId = Integer.parseInt(request.getParameter("noteId").trim());
         Session s = FactoryProvider.getFactory().openSession();
         Transaction tx1 = s.beginTransaction();
         TODO todo =s.get(TODO.class,noteId);
         todo.setTitle(title);
         todo.setDescription(content);
         todo.setAddedDate(new Date());
         tx1.commit();
         s.close();
         response.sendRedirect("all_notes.jsp");
     }
     catch (Exception e)
     {
     e.printStackTrace();
     }
}
}
