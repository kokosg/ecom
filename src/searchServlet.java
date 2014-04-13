

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class searchServlet
 */
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("searchServlet.jsp").forward(request, response);
		System.out.println("123");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// sets the header
		//request.getRequestDispatcher("forms/search.jsp").forward(request, response);
		//response.setContentType("text/html");
		// define the variable connection
		Connection conn = null;
		String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
		String dbName = "team104";
		String driver = "com.mysql.jdbc.Driver";
		String dbusername = "team104";
		String dbpassword = "4073dc3d";
		Statement statement;

		try {
			// loads the drivers
			Class.forName(driver).newInstance();
			// connects to the database
			conn = DriverManager
					.getConnection(url + dbName, dbusername, dbpassword);
			String pid = request.getParameter("twitterID");
			ArrayList twitterList = null;
			ArrayList tweetList = new ArrayList();
			String query = "";
			
			String categoryType = request.getParameter("item");


			System.out.println(categoryType);
			
			// validates before select from the table
//			if (pid.isEmpty() || (pid.equals("*"))) {
			if (categoryType.equals("article")) {
				query = "select * from User";
			} else {
				query = "select * from AuthorReviewer";
			}

			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				
				System.out.println("11");
				
				/*twitterList = new ArrayList();
				twitterList.add(result.getString(1));
				twitterList.add(result.getString(2));
				tweetList.add(twitterList);*/
				
				System.out.println(result.getString(2));
				
				response.getWriter().println("<tr><td>" + result.getString(1) + 
						"<td>" + result.getString(2) + "</td></tr>");
				
				//System.out.println(tweetList.toString());

			}
			//request.setAttribute("tweetList", tweetList);
			//request.getRequestDispatcher("forms/search.jsp").forward(request, response);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
