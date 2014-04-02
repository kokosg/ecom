

import java.sql.*;



public class DbManager {
	private static Connection conn= null;
	public DbManager(){
	}
	
	public static void insert(GetsSets set) throws SQLException, ClassNotFoundException{
		conn =  (Connection) ConnectionManager.getInstance().getConnection();
		String sql = "INSERT INTO register(fname,lname,gender,country,city,email,password,age,address,skill) VALUES(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt =   conn.prepareStatement(sql);
		pstmt.setString(1, set.getFname());
		pstmt.setString(2, set.getLname());
		pstmt.setString(3, set.getGender());
		pstmt.setString(4, set.getCountry());
		pstmt.setString(5, set.getCity());
		pstmt.setString(6, set.getEmail());
		pstmt.setString(7, set.getPassword());
		pstmt.setString(8, set.getAge());
		pstmt.setString(9, set.getAddress());
		pstmt.setString(10, set.getSkill());
		pstmt.executeUpdate();
		conn.close();
		System.out.println("connection closed");
	}
}
