<%@page import="com.user.Post"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.Db.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	UserDetails usere =(UserDetails)session.getAttribute("userD");
	
	if(usere==null){
		response.sendRedirect("login.jsp");
		session.setAttribute("login-error", "Please login...");
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Notes</title>
<%@include file="all_component/allcss.jsp"%>

</head>
<body>

<%     Integer noteid=Integer.parseInt(request.getParameter("note_id"));
        
PostDAO post =new PostDAO(DBConnect.getConn());
     Post p=post.getDataById(noteid);
     

%>
      <h1>Edit page</h1>
      <%@include file="all_component/navbar.jsp"%>
	<div class="container-fuild">

		<h1 class="text-center">Edit Your Notes</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="NoteEditServlet" method="post">
					  <input type="hidden" value="<%=noteid%>" name ="noteid">
					 
						<div class="form-group">
			

							<label for="exampleInputEmail1">Enter Title</label> 
							<input	type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title" required="required" value="<%=p.getTitle()%>">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<div class="conteiner text-center">
							<textarea rows="14" cols="form-control" name="content"
								required="required"><%=p.getContent() %></textarea>
						</div>
						</div>

						<div class="conteiner text-center">
							<button type="submit"  class="btn btn-primary">Submit</button>
						</div>
					</form>
					</div>
				</div>
			
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>
      
</body>
</html>