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

public class SerieDao extends ObjetoDao implements InterfazDao<Serie> {

	private static Connection connection;

	public SerieDao() {

	}

	@Override
	public ArrayList<Serie> buscarTodos() {
		connection = openConnection();
		String query = "select * from series";
		Serie serie = null;
		ArrayList<Serie> series = new ArrayList<Serie>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				serie = new Serie(rs.getInt("id"), rs.getString("titulo"), rs.getInt("edad"),
						rs.getString("plataforma"));
				series.add(serie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return series;
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
				serie = new Serie(rs.getInt("id"), rs.getString("titulo"), rs.getInt("edad"),
						rs.getString("plataforma"),null);
				
				serie.setTemporadas(obtenerTemporadas(serie));

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

		connection = openConnection();

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
	public void modificar(Serie serie) {

		int id = serie.getId();
		String titulo = serie.getTitulo();
		int edad = serie.getEdad();
		String plataforma = serie.getPlataforma();

		connection = openConnection();

		String query = "update series set titulo = ?, edad = ?, plataforma = ? where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, titulo);
			ps.setInt(2, edad);
			ps.setString(3, plataforma);
			ps.setInt(4, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

	public ArrayList<Temporada> obtenerTemporadas(Serie serie) {

		ArrayList<Temporada> temporadas = new ArrayList<>();
		connection = openConnection();
		String query = "select * from temporadas where serie_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, serie.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Temporada temp = new Temporada(rs.getInt("id"), rs.getInt("num_temporadas"), rs.getString("titulo"),
						serie);
				temporadas.add(temp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temporadas;

	}

	public ArrayList<Temporada> obtenerTemporadasPorSerieId(int serie_id) {

		ArrayList<Temporada> temporadas = new ArrayList<>();
		connection = openConnection();
		String query = "select * from temporadas where serie_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, serie_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Temporada temp = new Temporada(rs.getInt("id"), rs.getInt("num_temporadas"), rs.getString("titulo"),
						buscarPorId(serie_id));

				temporadas.add(temp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temporadas;

	}

	@Override
	public void borrar(Serie serie) {
		
		

	}

}
