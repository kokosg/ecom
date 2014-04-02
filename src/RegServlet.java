

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StringBuilder csvSkills = new StringBuilder();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fNm");
		String lname = request.getParameter("lNm");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String skills[] = request.getParameterValues("skills");
	
		if(skills!=null){
			for(String skill: skills){
				if(csvSkills.length()>0)
					csvSkills.append(",");
				csvSkills.append(skill);
			}
		}else
			csvSkills.append("");
		String csvSkill = csvSkills.toString();
		
		GetsSets sets = new GetsSets();
		sets.setFname(fname);
		sets.setLname(lname);
		sets.setAge(age);
		sets.setEmail(email);
		sets.setAddress(address);
		sets.setCountry(country);
		sets.setCity(city);
		sets.setGender(gender);
		sets.setPassword(password);
		sets.setSkill(csvSkill);
		
		try {
			
			DbManager.insert(sets);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}

}
