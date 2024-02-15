

<%@page import="com.tech.blog.entities.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<div class="row">

	<%
	PostDao dao = new PostDao(ConnectionProvider.getCon());

	int catId = Integer.parseInt(request.getParameter("cid"));

	ArrayList<Post> allPosts = new ArrayList<Post>();
	if (catId == 0) {
		allPosts = dao.getAllPosts();
	} else {
		allPosts = dao.getAllPostByCat(catId);
	}

	for (Post p : allPosts) {
	%>
	<div class="col-md-6 mt-2">
		<div class="card">
			<img class="card-img-top" src="blogPics/<%=p.getpPick()%>"
				alt="Card image cap">
			<div class="card-body">
				<b> <%=p.getpTitle()%>
				</b>
				<p>
					<%=p.getpContent()%>
				</p>
			</div>
			<div class="card-footer text-center">
				<a href="#!" class="btn btn-outline-primary btn-sm"> <i
					class="fa fa-thumbs-o-up"> <span>10</span>
				</i>
				</a>
				<a href="showBlogPage.jsp?postId=<%= p.getpId() %>" class="btn btn-outline-primary btn-sm">Read more..</a>
				<a href="#!" class="btn btn-outline-primary btn-sm"> <i
					class="fa fa-commenting-o"> <span>20</span>
				</i>
				</a>
			</div>
		</div>
	</div>
	<%
	}
	%>

</div>
