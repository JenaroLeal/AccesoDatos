package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Pelicula;

public class PeliculaDao extends ObjetoDao implements InterfazDao<Pelicula> {

	private static Connection connection;

	@Override
	public ArrayList<Pelicula> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pelicula buscarporId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Pelicula t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar(Pelicula t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Pelicula t) {
		// TODO Auto-generated method stub

	}

	public void borrarPorCompositor(int compositor_id) {
		connection = openConnection();

		String query = "Delete from peliculas where compositor_id= ? ";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, compositor_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}

}
