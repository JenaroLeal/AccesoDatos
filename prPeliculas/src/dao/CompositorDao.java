package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Compositor;
import pojo.Pelicula;

/**
 * Clase para poder utilizar los diferentes metodos asignados a los compositores
 * @author jenaro
 *
 */
public class CompositorDao extends ObjetoDao implements InterfazDao<Compositor> {

	//Variable para poder conectar con la base de datos
	private static Connection connection;
	
	public CompositorDao() {
		
	}

	/*
	 * Método para poder buscar todos los compositores
	 * return, los compositores encontrados
	 */
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
				ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
				compositor = new Compositor(rs.getInt("id"),rs.getString("nombre"),rs.getString("nacionalidad"),rs.getInt("año_nacimiento"),peliculas);
				String query_peliculas = "select * from peliculas where compositor_id = ?";
				PreparedStatement ps_peliculas = connection.prepareStatement(query_peliculas);
				ps_peliculas.setInt(1, rs.getInt("id"));
				ResultSet rs_peliculas = ps_peliculas.executeQuery();
				
				while (rs_peliculas.next()) {
					Pelicula pelicula = new Pelicula(rs_peliculas.getInt("id"),
							rs_peliculas.getString("nombre"),
							rs_peliculas.getInt("duracion_min"),
							rs_peliculas.getInt("año_lanzamiento"));
					peliculas.add(pelicula);
				}
				compositor.setPeliculas(peliculas);
				compositores.add(compositor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return compositores;
	}

	/**
	 * Método para poder buscar un compositor en funcion de su id
	 * i, el id que queremos buscar
	 * return el compositor encontrado
	 */
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

	/**
	 * Método para poder insertar un compositor
	 * compositor, el que queremos insertar
	 */
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

	/**
	 * Método para poder modificar alguno de los datos del compositor
	 * compositor, el que queremos modificar
	 */
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

	/*
	 * Método que nos permite borrar un compositor
	 * compositor, el que queremos eliminar
	 */
	@Override
	public void borrar(Compositor compositor) {
		
		
		int compositor_id =compositor.getId();
		PeliculaDao peliculaDao = new PeliculaDao();
		peliculaDao.borrarPorCompositor(compositor_id);
		connection=openConnection();
		
		String query = "delete from compositores where id = ?";
		try {
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, compositor_id);
		ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		closeConnection();

	}
	
	/*
	 * Método para obtener todas las peliculas en las que ha participado un compositor
	 * compositor, el que queremos saber las peliculas en las que ha participado
	 * return las peliculas en las que ha participado
	 */

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
	
	/*
	 * Método para obtener las peliculas de un compositor usando su id
	 * compositor_id, el id del compositor que queremos obtener las peliculas
	 * return las peliculas del compositor
	 */
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
	/*
	 * Método para eliminar la tabla compositores
	 */
	public void eliminarTablaCompositor() {
		connection=openConnection();
		String query = "drop table compositores";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	/*
	 * Método para crear la tabla compositores
	 */
	public void crearTablaCompositores() {
		connection=openConnection();
		String query = "create table compositores (\r\n"
				+ "id int primary key auto_increment,\r\n"
				+ "nombre varchar (40),\r\n"
				+ "nacionalidad varchar(40),\r\n"
				+ "año_nacimiento int\r\n"
				+ ");";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

}
