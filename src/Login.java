

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
     
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eml= request.getParameter("email");
		String pwd=request.getParameter("password");
		PrintWriter out= response.getWriter();
		
		
		String msg="";
		Connection conn =null;
		String url ="stusql.dcs.shef.ac.uk/";
		String dbName="team104";
		String driver ="com.mysql.jdbc.Driver";
		String dbusername= "team104";
		String dbpassword ="4073dc3d";
		
		try{
			Class.forName(driver).newInstance();
			conn=(Connection) DriverManager.getConnection(url+dbName,dbusername,dbpassword);
			String strQuery="select * from user where email ='" + eml; //+ "'and password ='" + pwd +" ' ";
			Statement st=(Statement) conn.createStatement();
			ResultSet rs=st.executeQuery(strQuery);
			response.setContentType("text/html");
			
			String query ="select * from user where email='" + eml + "'";
			Statement statement=(Statement) conn.createStatement();
			ResultSet result=statement.executeQuery(query);
			response.setContentType("text/html");
			if(result.next()){
			name=(String) result.getObject("email");
			System.out.println(name);
			}
			if(rs.next()){
				msg="Your login has been successful";
				response.getWriter().println("<font size='6'color = red> <font size='8' color = black> Welcome to E-Comm Journal </font><br>" + name + "," +msg + "</font>");
			}
			else{
				msg ="Your login Failed";
				response.getWriter().println("<font size='8'color = red>"+msg);
			}
			rs.close();
			st.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
