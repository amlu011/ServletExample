package com.thoughtclan;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Todo;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	UserTodoDao user = new UserTodoDao();
		int u_id=Integer.parseInt(request.getParameter("userId"));
		String todo=request.getParameter("todo");
		
		Todo todoObj =new Todo();
		todoObj.setTodo(todo);
		todoObj.setUser_id(u_id);
		
		
    	user.insertTodo(todoObj);
    	request.setAttribute("u_id",u_id);
    	
    	RequestDispatcher rd=request.getRequestDispatcher("DisplayServlet");
		System.out.println("Sending...............................................");
		rd.forward(request, response);
		
		
		
		
		
	}
}
