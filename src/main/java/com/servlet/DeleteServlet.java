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


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer noteid= Integer.parseInt(request.getParameter("note_id"));
		PostDAO dao=new PostDAO(DBConnect.getConn());
		
		boolean f=dao.deleteNote(noteid);
		HttpSession session =null;
		if(f) {
			 session =request.getSession();
			session.setAttribute("updateMsg","Note delete successfully");
			response.sendRedirect("showNotes.jsp");
		}else {
			session =request.getSession();
			session.setAttribute("wrongMsg","Somethig went wrong on server");
			response.sendRedirect("showNotes.jsp");
		}
		
	}

}
