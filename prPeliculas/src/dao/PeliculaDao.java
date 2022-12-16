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
 * Clase para poder usar diferentes funciones relativas a las peliculas
 * @author jenaro
 *
 */
public class PeliculaDao extends ObjetoDao implements InterfazDao<Pelicula> {
/*
 * Variable para poder conectar con la base de datos
 */
	private static Connection connection;

	
	/*
	 * Método que nos permite buscar todas las peliculas
	 * return las peliculas encontradas
	 */
	@Override
	public ArrayList<Pelicula> buscarTodos() {
		connection = openConnection();
		String query = "select * from peliculas";
		Pelicula pelicula = null;
		ArrayList<Pelicula> peliculas = null;

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				rs.getInt("compositor_id");
				CompositorDao compDao = new CompositorDao();

				Compositor c = compDao.buscarporId(0);

				pelicula = new Pelicula(rs.getInt("id"), rs.getString("nombre"), rs.getInt("duracion_min"),
						rs.getInt("año_lanzamiento"), c);

				peliculas.add(pelicula);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return peliculas;
	}
	
	/*
	 * Método para poder buscar una pelicula en funcion de su id
	 * i, el id a buscar
	 * return la pelicula
	 */

	@Override
	public Pelicula buscarporId(int i) {
		connection = openConnection();
		String query = "select * from peliculas where id = ?";
		Pelicula peli = null;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CompositorDao compDao = new CompositorDao();
				Compositor c = compDao.buscarporId(peli.getCompositor().getId());
				peli = new Pelicula(rs.getInt("id"), rs.getString("nombre"), rs.getInt("duracion_min"),
						rs.getInt("año_lanzamiento"), c);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return peli;
	}
	
	/*
	 * Método para poder inserta peliculas
	 * p, pelicula a insertar
	 */

	@Override
	public void insertar(Pelicula p) {

		connection = openConnection();
		String query = "insert into peliculas (nombre, duracion_min, año_lanzamiento, compositor_id) values (?, ?, ?, ? )";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getDuracion());
			ps.setInt(3, p.getAño_lanzamiento());
			ps.setInt(4, p.getCompositor().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	
	/*
	 * Método para poder modificar una pelicula
	 * p, pelicula que queremos modificar
	 */

	@Override
	public void modificar(Pelicula p) {

		int id = p.getId();
		String nombre = p.getNombre();
		int duracion = p.getDuracion();
		int año = p.getAño_lanzamiento();

		connection = openConnection();
		String query = "update peliculas set nombre = ?, duracion_min = ?, año_lanzamiento = ? where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setInt(2, duracion);
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
	 * Método para poder borrar una película
	 * p, pelicula a borrar
	 */
	@Override
	public void borrar(Pelicula p) {

		connection = openConnection();
		int id = p.getId();
		String query = "delete from peliculas where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();

	}
	
	/*
	 * Método para poder borrar una pelicula en funcion de su compositor
	 * compositor_id, el id del compositor que queremos borrar
	 */

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
	
	/*
	 * Método para poder encontrar las peliculas en funcion de los años
	 * primero-segundo, los márgenes de años en los que se encuentran las peliculas que queremos buscar
	 * return todas las peliculas entre esos años
	 */
	public ArrayList<Pelicula>peliculasPorDecada(int primero, int segundo){
		
		Pelicula pelicula = null;
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		
		connection = openConnection();
		String query = "select * from peliculas where año_lanzamiento>=? and año_lanzamiento<?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, primero);
			ps.setInt(2, segundo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Compositor c = new Compositor();
				pelicula = new Pelicula (rs.getInt("id"),rs.getString("nombre"),rs.getInt("duracion_min"),rs.getInt("año_lanzamiento"),c);
				peliculas.add(pelicula);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return peliculas;
		
	}
	/*
	 * Método para eliminar la tabla peliculas
	 */
	
	public void eliminarTablaPelicula() {
		connection=openConnection();
		String query = "drop table peliculas";
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
	 * Método para crear la tabla peliculas
	 */
	public void crearTablaPeliculas() {
		connection=openConnection();
		String query = "create table peliculas (\r\n"
				+ "id int primary key auto_increment,\r\n"
				+ "nombre varchar (40),\r\n"
				+ "duracion_min int,\r\n"
				+ "año_lanzamiento int,\r\n"
				+ "compositor_id int,\r\n"
				+ "constraint fk_compositor_id foreign key (compositor_id) references compositores (id)\r\n"
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
