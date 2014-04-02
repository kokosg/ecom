

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public static ConnectionManager instance = null ;
	private final String USERNAME = "team104";
	private final String PASSWORD = "4073dc3d";
	private final String CONN_STRING = "stusql.dcs.shef.ac.uk/";
	String dbName="team104";
	private Connection conn = null;

	private ConnectionManager() throws ClassNotFoundException{
	
	}
	
	public static ConnectionManager getInstance() throws ClassNotFoundException{
		if(instance==null){
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	private boolean openConnection() throws ClassNotFoundException{
		try{
			System.out.println("connection open");
			Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(CONN_STRING+dbName,USERNAME,PASSWORD);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}
	
	public Connection getConnection() throws ClassNotFoundException{
		if(conn==null){
			
			if(openConnection()){
				System.out.println("Connection opened");
				return conn;
			}
			else
				return null ;
		}
		return conn;
	}
	
	public void close(){
		System.out.println("Closing connection");
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

