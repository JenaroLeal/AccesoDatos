package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Temporada;
import util.DataBaseConnection;

public class TemporadaDao implements Dao<Temporada>{

	private static Connection connection;
	
	public TemporadaDao() {
		
	}
	@Override
	public ArrayList<Temporada> buscatTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temporada buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Temporada temp) {
		
connection=openConnection();
		
		String query = "insert into temporadas (num_temporadas, titulo,  serie_id) values (?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, temp.getNum_temporada());
			ps.setString(2, temp.getTitulo());
			ps.setInt(3, temp.getSerie().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}

	@Override
	public void modificar(Temporada t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Temporada t) {
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
