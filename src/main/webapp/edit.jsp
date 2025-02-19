<%@page import="com.helper.FactoryProvider"%>
<%@page import="java.lang.*"%>
<%@page import="org.hibernate.*"%>
<%@page import="java.util.*"%>
<%@page import="com.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Notes : TODO</title>
<%@ include file="all_js_css.jsp"%>
</head>



<body>

<div class="container">
  <%@include file="navbar.jsp" %>
  <h1>Edit your note</h1>
  <br>
<%
int noteId = Integer.parseInt(request.getParameter("note_id").trim());
 Session s1 = FactoryProvider.getFactory().openSession();
 TODO todo  = (TODO)s1.get(TODO.class, noteId);
%>

<!--This is edit form -->
<form action="UpdateServlet" method="post">
<input value="<%= todo.getId() %>" name="noteId" type="hidden" />
  <div class="mb-3 form-group">
    <label for="title" class="form-label">Note Title</label>
    <input
    name="title"
    required
    type="text"
    class="form-control"
    id="Title"
    aria-describedby="emailHelp"
    placeholder="Enter here"
    value="<%= todo.getTitle()  %>" />
  </div>

  <div class="mb-3">
    <label for="content" class="form-label">Note Content</label>
    <textarea name="content" required id="content"
     placeholder="Start typing here"
     class="form-control"
     style="height:400px;"><%= todo.getDescription() %>
     </textarea>

     </div>
<div class="container text-center">
 <button type="submit" class="btn btn-success">Confirm Changes</button>

</div>

</form>



  </div>




</body>






</html>