package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Compositor;
import pojo.Pelicula;

public class CompositorDao extends ObjetoDao implements InterfazDao<Compositor> {

	private static Connection connection;
	
	public CompositorDao() {
		
	}

	@Override
	public ArrayList<Compositor> buscarTodos() {
		
		connection = openConnection();
		
		String query = "select * from compositores";
		Compositor compositor = null;
		
		ArrayList<Compositor> compositores = new ArrayList<Compositor>();
		
		 
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				compositor = new Compositor(rs.getInt("id"),rs.getString("nombre"),rs.getString("nacionalidad"),rs.getInt("año_nacimiento"));
				compositores.add(compositor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return compositores;
	}

	@Override
	public Compositor buscarporId(int i) {

		connection = openConnection();
		String query = "select * from compositores where id = ?";
		Compositor compositor = null;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				compositor = new Compositor(rs.getInt("id"), rs.getString("nombre"), rs.getString("nacionalidad"),
						rs.getInt("año_nacimiento"), null);
				compositor.setPeliculas(obtenerPeliculas(compositor));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return compositor;
	}

	@Override
	public void insertar(Compositor compositor) {

		connection = openConnection();
		String query = "insert into compositores (nombre,nacionalidad,año_nacimiento) values(?, ?, ?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, compositor.getNombre());
			ps.setString(2, compositor.getNacionalidad());
			ps.setInt(3, compositor.getAño_nacimiento());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void modificar(Compositor compositor) {

		int id = compositor.getId();
		String nombre = compositor.getNombre();
		String nacionalidad = compositor.getNacionalidad();
		int año = compositor.getAño_nacimiento();

		connection = openConnection();
		String query = " update compositores set nombre = ?, nacionalidad = ?, año_nacimiento= ? where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, nombre);
			ps.setString(2, nacionalidad);
			ps.setInt(3, año);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

	@Override
	public void borrar(Compositor compositor) {
		
		int compositor_id =compositor.getId();
		PeliculaDao peliculaDao = new PeliculaDao();
		peliculaDao.borrarPorCompositor(compositor_id);
		
		String query = "delete from compositores where id = ?";
		try {
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, compositor_id);
		ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		connection=openConnection();
		
		closeConnection();

	}

	public ArrayList<Pelicula> obtenerPeliculas(Compositor compositor) {

		ArrayList<Pelicula> peliculas = new ArrayList();
		connection = openConnection();
		String query = "select * from peliculas where compositor_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, compositor.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Pelicula pelicula = new Pelicula(rs.getInt("id"), rs.getString("nombre"), rs.getInt("duracion_min"),
						rs.getInt("año_lanzamiento"), compositor);

				peliculas.add(pelicula);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return peliculas;

	}
	public ArrayList<Pelicula> obtenerPeliculasPorCompositorId (int compositor_id){
		
		ArrayList<Pelicula> peliculas = new ArrayList<>();
		connection = openConnection();
		String query =" select * from peliculas where compositor_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, compositor_id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Pelicula pelicula = new Pelicula (rs.getInt("id"),rs.getString("nombre"),rs.getInt("duracion_min"),rs.getInt("año_lanzzamiento"),buscarporId(compositor_id));
				peliculas.add(pelicula);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return peliculas;
		
	}

}