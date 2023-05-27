package com.servlet;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db.DBConnect;
import com.Db.UserDao;
import com.mysql.cj.Session;
import com.user.UserDetails;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
   public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServerException,IOException{
	    String name =request.getParameter("fname");
	    String email=request.getParameter("uemail");
	    String password=request.getParameter("upassword");
	    
	    UserDetails us=new UserDetails();
	    us.setName(name);
	    us.setEmail(email);
	    us.setPassword(password);
	    
	    UserDao
	    dao=new UserDao(DBConnect.getConn());
	    boolean f=dao.addUser(us);
		HttpSession session=request.getSession();
	    if(f) {
	    
	    	session.setAttribute("reg-sucess","Registration successfully");
	    	response.sendRedirect("register.jsp");
	    }else {
	       session=request.getSession();
	       session.setAttribute("failed-msg","something went wrong on server");
	       response.sendRedirect("register.jsp");
	    }
	    
  }
}

