<%@page import="com.tech.blog.dao.UserDao"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="com.tech.blog.entities.User"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.entities.Message"%>
<%@page import="com.tech.blog.entities.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp"%>

<%
int postId = Integer.parseInt(request.getParameter("postId"));

PostDao postDao = new PostDao(ConnectionProvider.getCon());
Post post = postDao.getPostById(postId);

UserDao userDao = new UserDao(ConnectionProvider.getCon());
User writerUser = userDao.getUserById(post.getUserId());
%>

<%
User loggedInUser = (User) session.getAttribute("currentUser");
if (loggedInUser == null) {
	response.sendRedirect("login.jsp");
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=post.getpTitle()%></title>


<!-- Bootstrap & CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<link rel="stylesheet" href="css/myStyle.css" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<style>
.post-title {
	font-weight: 100;
	font-size: 30px;
}

.post-content {
	font-weight: 100;
	font-size: 25px;
}

.post-writer{

}

.post-date{
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>

	<!-- start of nav -->
	<nav class="navbar navbar-expand-lg navbar-dark primary-background">
		<a class="navbar-brand" href="/TechBlog"> <span
			class="fa fa-comments"></span> Tech Blog
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="Profile.jsp">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Categories </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Programming language</a> <a
							class="dropdown-item" href="#">Project implementation</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Data Structures</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#addBlogModal" href="#">Do post</a></li>
			</ul>

			<ul class="navbar-nav mr-right">
				<li><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal"> <span class="fa fa-user"></span> <%=loggedInUser.getName()%>
				</a></li>
				<li><a class="nav-link" href="Logout"> <span
						class="fa-solid fa-arrow-right-from-bracket"></span> Logout
				</a></li>
			</ul>
		</div>
	</nav>


	<%
	Message msg = (Message) session.getAttribute("msg");
	if (msg != null) {
	%>
	<div class="alert '+ <%=msg.getCssClass()%> +'" role="alert">
		<%=msg.getContent()%>
	</div>
	<%
	session.removeAttribute("msg");
	}
	%>

	<!-- end of nav -->

	<!-- Start of main content -->

	<div class="container">
		<div class="row my-4">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-header primary-background text-white">
						<h4 class="post-title">
							<%=post.getpTitle()%>
						</h4>
					</div>
					<div class="card-body">
						<img class="card-img-top" src="blogPics/<%=post.getpPick()%>"
							alt="Card image cap">
							
							<div class="row py-3">
								<div class="col-md-8 post-writer"> <a href="#!"> <%= writerUser.getName() %> </a> posted: </div>
								<div class="col-md-4 post-date"> <%= post.getpDate().toLocaleString() %> </div>
							</div>
							
						<p class="post-content">
							<%=post.getpContent()%>
						</p>

						<br> <br>
						<div class="post-code">
							<pre> <%=post.getpCode()%> </pre>
						</div>
					</div>

					<div class="card-footer primary-background text-white">
						<a href="#!"
							class="btn btn-outline-primary btn-sm text-white border-white">
							<i class="fa fa-thumbs-o-up"> <span>10</span>
						</i>
						</a> <a href="#!"
							class="btn btn-outline-primary btn-sm text-white border-white">
							<i class="fa fa-commenting-o"> <span>20</span>
						</i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- End of main content -->


	<!-- Profile modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header primary-background text-white">
					<h5 class="modal-title" id="exampleModalLabel">TechBlog</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container text-center">
						<img alt="ProfilePicture" class="img-fluid"
							style="border-radius: 50%; max-width: 150px"
							src="pics/<%=loggedInUser.getProfile()%>" />
						<h5 class="modal-title" id="exampleModalLabel">
							<%=loggedInUser.getName()%>
						</h5>
						<div id="userDetails">
							<table class="table">
								<tbody>
									<tr>
										<th scope="row">Id:</th>
										<td><%=loggedInUser.getId()%></td>
									</tr>
									<tr>
										<th scope="row">Email:</th>
										<td><%=loggedInUser.getEmail()%></td>
									</tr>
									<tr>
										<th scope="row">Gender:</th>
										<td><%=loggedInUser.getGender()%></td>
									</tr>
									<tr>
										<th scope="row">About:</th>
										<td><%=loggedInUser.getAbout()%></td>
									</tr>
									<tr>
										<th scope="row">Registered on:</th>
										<td><%=loggedInUser.getDataTime()%></td>
									</tr>
								</tbody>
							</table>
						</div>

						<!-- Profile edit -->
						<div id="userEdit" style="display: none">
							<h3 class="mt-3">Please edit carefully</h3>
							<form action="EditUser" method="post"
								enctype="multipart/form-data">
								<table class="table">
									<tr>
										<td>Id:</td>
										<td><%=loggedInUser.getId()%></td>
									</tr>
									<tr>
										<td>Email:</td>
										<td><input type="email" required name="userEmail"
											class="form-control" aria-describedby="emailHelp"
											value="<%=loggedInUser.getEmail()%>" /></td>
									</tr>
									<tr>
										<td>Name:</td>
										<td><input type="text" required name="userName"
											class="form-control" value="<%=loggedInUser.getName()%>" />
										</td>
									</tr>
									<tr>
										<td>Password:</td>
										<td><input type="password" required name="userPassword"
											class="form-control" value="<%=loggedInUser.getPassword()%>" />
										</td>
									</tr>
									<tr>
										<td>about</td>
										<td><textarea name="userAbout" class="form-control"
												rows="3">
<%=loggedInUser.getAbout()%></textarea></td>
									</tr>
									<tr>
										<td>New profile pic:</td>
										<td><input type="file" name="userProfilePic"
											class="form-control" /></td>
									</tr>
								</table>
								<div class="container">
									<button type="submit" class="btn btn-outline-primary">
										Save</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="userEditBtn" type="button" class="btn btn-primary">
						Edit</button>
				</div>
			</div>
		</div>
	</div>

	<!-- End of profile modal -->

	<!-- Add blog modal -->
	<div class="modal fade" id="addBlogModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Write Blog here</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="addPostForm" action="AddPost" method="post">
						<div class="form-group">
							<select name="postCatagory" class="form-control">
								<option value="" selected disabled>--- Select catagory
									---</option>
								<%
								PostDao pd = new PostDao(ConnectionProvider.getCon());
								ArrayList<Category> categories = pd.getAllCategories();
								for (Category c : categories) {
								%>
								<option value="<%=c.getCid()%>"><%=c.getName()%></option>
								<%
								}
								%>
							</select>
						</div>
						<div class="form-group">
							<input type="text" name="postTitle" class="form-control"
								placeholder="Enter post title here" />
						</div>
						<div class="form-group">
							<textarea name="postContent" class="form-control" cols="5"
								placeholder="Enter post content here"></textarea>
						</div>
						<div class="form-group">
							<textarea name="postCode" class="form-control" cols="5"
								placeholder="Enter your code here (if any)"></textarea>
						</div>
						<div class="form-group">
							<p>Select cover photo.</p>
							<input type="file" name="postPic" class="form-control" />
						</div>
						<button type="submit">Add blog</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- End of Add blog modal -->




	<!-- Js -->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<script>
      $(document).ready(() => {
        let editStatus = false;
        $("#userEditBtn").click(() => {
          if (!editStatus) {
            $("#userDetails").hide();
            $("#userEdit").show();
            editStatus = true;
            $(document.getElementById("userEditBtn")).text("Back");
          } else {
            $("#userDetails").show();
            $("#userEdit").hide();
            editStatus = false;
            $(document.getElementById("userEditBtn")).text("Edit");
          }
        });
      });
    </script>

	<!-- Add post Js -->
	<script>
      $(document).ready(() => {
        $("#addPostForm").on("submit", (e) => {
          e.preventDefault();

          let data = new FormData(document.getElementById("addPostForm"));
          $.ajax({
            url: "AddPost",
            type: "POST",
            data: data,
            success: function (data, status, jqXHR) {
              console.log(data);
              if (data.trim() == "Seccess") {
                swal("Good job!", "Saved successfully", "success");
              } else {
                swal("Error!", "Something went wrong", "error");
              }
            },
            error: function (jqXHR, status, error) {
              /* console.log(error); */
              swal("Error!", "Something went wrong", "error");
            },
            processData: false,
            contentType: false,
          });
        });
      });
    </script>
</body>
</html>