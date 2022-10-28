package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;

import util.DataBaseConnection;

public class SerieDao implements Dao<Serie>{
	
	private static Connection connection;
	
	public SerieDao() {
		
	}

	@Override
	public ArrayList<Serie> buscatTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serie buscarPorId(int i) {

		connection = openConnection();
		String query = "select * from series where id = ?";
		Serie serie = null;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				serie = new Serie(rs.getInt("id"),rs.getString("titulo"), rs.getInt("edad"),
						rs.getString("plataforma"));
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

		return serie;
	}

	@Override
	public void insertar(Serie serie) {
	
		connection=openConnection();
		
		String query = "insert into series (titulo, edad, plataforma) values (?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, serie.getTitulo());
			ps.setInt(2, serie.getEdad());
			ps.setString(3, serie.getPlataforma());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}

	@Override
	public void modificar(Serie t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub
		
	}
	
	private static Connection openConnection() {

		DataBaseConnection dbConnection = new DataBaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}

	private static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
