<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
UserDetails user2 =(UserDetails)session.getAttribute("userD");
	
	if(user2==null){
		response.sendRedirect("login.jsp");
		session.setAttribute("login-error", "Please login...");
	}
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>
    <div class="container-fluid" >
    <%@include file="all_component/navbar.jsp" %>
    <div class="card py-5">
    <div class="card-body text-center " >
    <img alt="" src="photo/Book.jpg" class="img-fluid mx-auto" style="max-width: 350px" >
    <h1>START TAKING YOUR NOTES</h1>
    <a href="addNotes.jsp" class="btn btn-primary badge-pill btn-block">Start here
    </a>
    </div>
    </div>
    </div>
    <%@include file="all_component/footer.jsp" %>
</body>
</html>
