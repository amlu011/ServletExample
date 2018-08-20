

import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.User;
/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<User> dataList=new ArrayList<User>();

    	UserTodoDao user = new UserTodoDao();
		//int u_id=Integer.parseInt(request.getParameter("u_id"));
		//'System.out.println("Recived id: "+u_id);
    	dataList=user.displayUsers();
		request.setAttribute("data", dataList);
		RequestDispatcher rd=request.getRequestDispatcher("output.jsp");
		System.out.println("Sending...............................................");
		rd.forward(request, response);
		
		
		
			
		
	}
}
