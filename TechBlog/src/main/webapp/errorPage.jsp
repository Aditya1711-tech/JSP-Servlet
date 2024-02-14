<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Sorry! something went wrong</title>

    <!-- Bootstrap & CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/myStyle.css" type="text/css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
  </head>
  <body>
    <div class="container text-center">
      <img src="img/error.png" alt="Error" class="img-fluid" />
      <h3 class="display-3">Sorry something went wrong...</h3>
      <%= exception %>
      <a class="btn primary-background btn-lg" href="/TechBlog">Home</a>
    </div>
  </body>
</html>
