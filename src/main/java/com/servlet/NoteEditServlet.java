package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Db.DBConnect;
import com.Db.PostDAO;


@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			Integer noteid= Integer.parseInt(request.getParameter("noteid"));
			String Title=request.getParameter("title");
			String Content=request.getParameter("content");
			
			PostDAO dao=new PostDAO(DBConnect.getConn());
		   boolean f=	dao.postUpdate(noteid, Title, Content);
			  if(f) {
				 // System.out.println("Data success");
				  HttpSession session =request.getSession();
				  session.setAttribute("updateMsg", "Note successfully update");
				  response.sendRedirect("showNotes.jsp");
			  }
		
			  else {
				//  System.out.println("Note update");
				  HttpSession session =request.getSession();
				  session.setAttribute("updateMsg", "Note successfully update");
				  response.sendRedirect("showNotes.jsp");
				  
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
