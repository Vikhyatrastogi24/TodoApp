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
import java.io.PrintWriter;
import java.util.Date;

public class SaveNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveNoteServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
           //title,content fetch
          String title=  req.getParameter("title");
          String content=  req.getParameter("content");

          TODO note = new TODO(new Date(),content, title);
          //  System.out.println(note.getId()+" : " +note.getTitle());
         //hibernate:save()
            Session s1= FactoryProvider.getFactory().openSession();
Transaction tx = s1.beginTransaction();
s1.persist(note);
tx.commit();
s1.close();
resp.setContentType("text/html");
PrintWriter out=resp.getWriter();
out.println("<h1 style='text-align:center;'> Note is added successfully </h1>");
out.println("<h1 style='text-align:center;'> <a href='all_notes.jsp'>View All Notes</a> </h1>");




        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}