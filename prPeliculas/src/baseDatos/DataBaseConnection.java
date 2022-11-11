package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	
	Connection conexion;
	
	public Connection getConnection() {
		
		String dbName = "compositorespelis";
		String userName="root";
		String password = "jenaroleal";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/"+ dbName,userName,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conexion;
	}
	

}
