<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TODO App : Home</title>
  <%@include file="all_js_css.jsp" %>
  </head>
  <body>
  <div class="container">
  <%@include file="navbar.jsp" %>
  <div class="card mt-4 " style="height:100vh;border:black"  >
    <img src="images/notes_image_todo.png"   style="max-width:500px" class="card-img-top mx-auto fluid " alt="...">
    <div class="card-body text-center">
      <h5 class="card-title">TODO APP </h5>
      <p class="card-text">This App is Built using Advanced Java concepts and Hibernate</p>
      <a href="add_notes.jsp" class="btn btn-dark text-center">Lets Get Started </a>
    </div>
  </div>
  </div>
  </body>
</html>
