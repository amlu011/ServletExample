package com.thoughtclan;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.test.Todo;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Todo> dataList=new ArrayList<Todo>();

    	UserTodoDao userDAO= new UserTodoDao();
    	int u_id=-1;
    	
    	if(request.getParameter("u_id")!=null){
		u_id=Integer.parseInt(request.getParameter("u_id"));
    	}else {
    		u_id=(Integer) request.getAttribute("u_id");
    		
    	}
		
		
		//'System.out.println("Recived id: "+u_id);
    	dataList=userDAO.displayTodo(u_id);
		request.setAttribute("data", dataList);
		RequestDispatcher rd=request.getRequestDispatcher("todoDisp.jsp");
		System.out.println("Sending...............................................");
		rd.forward(request, response);
}
}