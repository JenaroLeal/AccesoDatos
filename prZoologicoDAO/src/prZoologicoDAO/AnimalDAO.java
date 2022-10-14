package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AnimalDAO {
	
	private static Connection conexion;
	
	public static void insertAnimal(Animal animal) {
		conexion = openConnection();
		
		String query = "insert into animales (nombre, habitat, peso_aprox) values (?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(query);
			
			preparedStatement.setString(1, animal.getNombre());
			preparedStatement.setString(2, animal.getHabitat());
			preparedStatement.setDouble(3, animal.getPeso_aprox());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	private static Connection openConnection() {
		
		DataBaseConnection dbConnection = new DataBaseConnection();
		conexion= dbConnection.getConnection();
		return conexion;
	}
	
	private static void closeConnection() {
		try {
			conexion.close();
			conexion=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
