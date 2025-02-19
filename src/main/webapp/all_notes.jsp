<%@page import="com.helper.FactoryProvider"%>
<%@page import="java.lang.*"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.*"%>
<%@page import="com.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes : TODO</title>
<%@ include file="all_js_css.jsp"%>
</head>


<body>

<div class="container">
<%@include file="navbar.jsp" %>
<br>
<h1 class="text-uppercase">All Notes</h1>
<div class="row">
<div class="col-12">

<%
Session s = FactoryProvider.getFactory().openSession();
Query<TODO> q= s.createQuery("from TODO ",TODO.class);
List<TODO> list =q.list();
for(TODO todo : list)
{
%>
<div class="card m t-3" >
  <img src="images/notes_image_todo.png" style="max-width:100px" class="card-img-top m-4 mx-auto" alt="notes icon">
  <div class="card-body px-5">
    <h5 class="card-title"><%= todo.getTitle() %></h5>
    <p class="card-text">
    <%= todo.getDescription()  %>

    </p>
<p><b><%= todo.getAddedDate() %></b> </p>
    <div class="container text-center mt-2">
    <a href="DeleteServlet?note_id=<%= todo.getId() %>" class="btn btn-danger">Delete</a>
    <a href="edit.jsp?note_id=<%= todo.getId() %>" class="btn btn-warning">Update</a>
    </div>

  </div>
</div>

<%

 }
s.close();

%>



</div>

</div>

</div>



</body>













</html>