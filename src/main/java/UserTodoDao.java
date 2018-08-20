import java.sql.*;

import java.util.*;

import javax.servlet.RequestDispatcher;

import com.test.User;
import com.test.Todo;

public class UserTodoDao {
	static Connection con;
	static String url;
	public static Connection makeConnection(){
		try{
			
			
			String url="jdbc:mysql://localhost/anushka";
			Class.forName("com.mysql.jdbc.Driver");
			try{
				
				con=DriverManager.getConnection(url, "root", "password");
			}
			
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
		}
		return con;
	}
	
	public List<User> displayUsers(){
		
		List<User> dataList=new ArrayList<User>();
		Statement statement=null;
		ResultSet rs=null;
			
		Connection conn1=UserTodoDao.makeConnection();
	try{
	
		 statement=conn1.createStatement();
		String sql = "SELECT * FROM USER";
		//String name = "";
		
	       rs = statement.executeQuery(sql);
	      while(rs.next()) {
	    	  
	    	  User u =new User();
	    	  u.setU_id(rs.getInt("u_id"));
	    	  u.setName(rs.getString("u_name"));
	    	  

	    	  dataList.add(u);
	    	  //name=rs.getString("u_name");
	    	  
	      }
	      //System.out.println("THIS IS ID VALUE  "+name);
	}
	catch(SQLException e){
		e.printStackTrace();
	}
return dataList;
	
	
		
	}
	
	public List<Todo> displayTodo(int u_id){
		User u =new User();
		
		List<Todo> dataList=new ArrayList<Todo>();
		Statement statement=null;
		ResultSet rs=null;
			
		Connection conn1=UserTodoDao.makeConnection();
	try{
	
		 statement=conn1.createStatement();
		String sql = "SELECT t_id,todo,user FROM TODO WHERE user="+u_id+" ";
		//String name = "";
		
	       rs = statement.executeQuery(sql);
	      while(rs.next()) {
	    	  Todo t = new Todo();
	    	  t.setT_id(rs.getInt("t_id"));
	    	  t.setTodo(rs.getString("todo"));
	    	  t.setUser_id(rs.getInt("user"));;
	    	  dataList.add(t);
	    	 

	    	 
	    	  //name=rs.getString("u_name");
	    	  
	      }
	      //System.out.println("THIS IS ID VALUE  "+name);
	}
	catch(SQLException e){
		e.printStackTrace();
	}
return dataList;
	
	
		
	}
	
	public void insertTodo(Todo todo){
		User u =new User();
		Todo t = new Todo();
		
		
		Connection conn1=UserTodoDao.makeConnection();
		 PreparedStatement pStatement=null;
	try{
		
		
		 String sql="insert into anushka.TODO(todo,user) values (?,?)";
		 pStatement=conn1.prepareStatement(sql);
		 //pStatement.setInt(1,5);
		 pStatement.setString(1,todo.getTodo());
		 pStatement.setInt(2, todo.getUser_id());
		
	     
	    	 pStatement.executeUpdate();

	    	 
	    	  //name=rs.getString("u_name");
	    	  
	      
	      //System.out.println("THIS IS ID VALUE  "+name);
	}
	catch(SQLException e){
		e.printStackTrace();
	}

	
	
		
	}
		
	}
	


