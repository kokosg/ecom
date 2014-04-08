
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
/*	////////////////////////////////////
	
	String name = (String) session.getAttribute("name");
	if (name != null) {
		// This user already has a session; show the name and show the list of
		// items entered.
		out.println("Hello, " + name + "!");

		response.encodeURL("RewriteDemo2.jsp");

	}
	// If name is passed in as a parameter, it must be as a response to
	// the form input. Put the name in the session and redirect the browser
	// to the second page.
	else if (request.getParameter("name") != null) {
		session.setAttribute("name", request.getParameter("name"));
		response.sendRedirect(response
				.encodeRedirectURL("RewriteDemo2.jsp"));
	} else {

response.encodeURL("RewriteDemo.jsp")

	
	//////////////////////////////////
	 * 
	 * 
	 * session.setAttribute("userid", null);
	 * session.invalidate();
*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String eml = request.getParameter("email");
				String pwd = request.getParameter("password");

				String msg = "";
				// sets the header
				response.setContentType("text/html");
				// define the variable connection
				Connection conn = null;
				String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
				String dbName = "team104";
				String driver = "com.mysql.jdbc.Driver";
				String dbusername = "team104";
				String dbpassword = "4073dc3d";
				try {
					// loads the drivers
					Class.forName(driver).newInstance();
					conn = DriverManager.getConnection(url + dbName, dbusername,
							dbpassword); 
					
					/*SELECT User.userID, User.Email, AuthorReviewer.password, Author.name, Author.surname, Author.isMainContact
					FROM User
					INNER JOIN Author
					ON User.userID = Author.userID
					INNER JOIN AuthorReviewer
					ON Author.authorID = AuthorReviewer.authorID*/
					
					
					String selectQuery = "SELECT User.Email, AuthorReviewer.password, Author.name, Author.surname, Editor.authorReviewerID"
							+ " from User INNER JOIN Author ON User.userID = Author.userID INNER JOIN AuthorReviewer ON Author.authorID = AuthorReviewer.authorID"
							+ " LEFT OUTER JOIN Editor ON AuthorReviewer.authorReviewerID = Editor.authorReviewerID"
							+ " where User.Email ='" + eml + "'and AuthorReviewer.password ='" + pwd + " ' ";
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(selectQuery);

					String name;
					if (rs.next()) {
						
						 //String email = rs.getString("User.Email");
				         //String password = rs.getString("AuthorReviewer.password");
						 String userName = rs.getString("Author.name");
				         String userSuername = rs.getString("Author.surname");
				         String isAdmin = rs.getString("Editor.authorReviewerID");
				         System.out.println(isAdmin);
				         
						HttpSession session = request.getSession();
			            name = (String) session.getAttribute("email");
			        	 if (request.getParameter("email") != null) {
			        		session.setAttribute("email", request.getParameter("email"));
			        		session.setAttribute("userName", userName);
			        		session.setAttribute("userSurname", userSuername);
			        		
			        		if (isAdmin == null) {
			        			session.setAttribute("userRole", "Author");
			        		} else if (isAdmin != null) {
			        			session.setAttribute("userRole", "Admin"); //change that
			        		}
			        		//response.sendRedirect(response.encodeRedirectURL("RewriteDemo2.jsp"));
			        	} if (name != null) {
			        		// This user already has a session; show the name and show the list of
			        		// items entered.
			        		System.out.println("already has a sessio" + name + "!");
			        	}

/*						msg = "Your login has been successful";
						response.getWriter()
								.println(
										"<font size='6'color = red> <font size='8' color = black> Welcome to E-Comm Journal </font><br>"
												+ session.getAttribute("email") + "," + msg + "</font>");*/
						
						request.getRequestDispatcher("index.jsp").forward(request,response);
						
					} else {
						msg = "<font size='8'color = red>Your login Failed</font>";
						request.setAttribute("message123", msg);
						//response.getWriter().println("<font size='8'color = red>1" + msg);
						request.getRequestDispatcher("index.jsp").forward(request,response);

					}
					rs.close();
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

}
