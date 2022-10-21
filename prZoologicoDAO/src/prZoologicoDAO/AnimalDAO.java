package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class AnimalDAO {

	private static Connection conexion;
	
	
	
	public static void updateAnimal (Animal animal) {
		
		conexion = openConnection();
		
		int id = animal.getId();
		String nombre = animal.getNombre();
		String habitat = animal.getHabitat();
		double peso_aprox = animal.getPeso_aprox();
		
		String query = "update animal set nombre = ?, habitat = ?, peso_aprox= ? where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, habitat);
			ps.setDouble(3, peso_aprox);
			ps.setInt(4, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static ArrayList<Animal> findAllAnimales() {

		conexion = openConnection();
		String query = "select * from animales";
		Animal animal = null;
		ArrayList<Animal> animales = null;

		try {
			Statement statement = conexion.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				animal = new Animal(rs.getInt("id"), rs.getString("nombre"), rs.getString("habitat"),
						rs.getDouble("peso_aprox"));
				animales.add(animal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return animales;
	}

	private static Animal findAnimalById(int id) {

		conexion = openConnection();
		String query = "select * from animales where id = ?";
		Animal animal = null;
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				animal = new Animal(rs.getInt("id"), rs.getString("nombre"), rs.getString("habitat"),
						rs.getDouble("peso_aprox"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return animal;
	}

	public static void deleteAnimalByNombre(String name) {

		conexion = openConnection();
		String query = "delete from animales where nombre = " + "'" + name + "'";
		try {
			Statement statement = conexion.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	public static void deleteAnimal() {

		conexion = openConnection();
		String query = "delete from animales";
		try {
			Statement statement = conexion.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

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
		conexion = dbConnection.getConnection();
		return conexion;
	}

	private static void closeConnection() {
		try {
			conexion.close();
			conexion = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
