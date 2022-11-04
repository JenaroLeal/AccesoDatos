package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import util.DataBaseConnection;

public class TemporadaDao extends ObjetoDao implements InterfazDao<Temporada>{

	private static Connection connection;
	
	public TemporadaDao() {
		
	}
	@Override
	public ArrayList<Temporada> buscarTodos() {
		connection = openConnection();
		String query = "select * from temporadas";
		Temporada temp = null;
		ArrayList<Temporada> temporadas = null;

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				rs.getInt("serie_id");
				SerieDao serieDao = new SerieDao();
				Serie s = serieDao.buscarPorId(0);
				
				temp = new Temporada(rs.getInt("id"), rs.getInt("num_temporadas"), rs.getString("titulo"),s);
						
				temporadas.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return temporadas;
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
		
		connection=openConnection();
		
		String query = "delete from temporadas where serie_id = "+t.getSerie().getId();
		
		try {
			Statement st = connection.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
	}
	

}