package pojo;

import java.util.ArrayList;

/**
 * Clase compositor
 * @author jenaro
 *
 */

public class Compositor {
	
	//Id del compositor
	private int id;
	//Nombre del compositor
	private String nombre;
	//Nacionalidad del compositor
	private String nacionalidad;
	//Años de nacimiento del compositor
	private int año_nacimiento;
	//Peliculas en las que ha participado el compositor
	private ArrayList<Pelicula> peliculas;
	
	/**
	 * Constructor de compositor en base a su nombre, nacionalidad y fecha de nacimiento
	 * @param nombre del compositor
	 * @param nacionalidad del compositor
	 * @param año_nacimiento del compositor
	 */
	
	public Compositor (String nombre, String nacionalidad, int año_nacimiento) {
		super();
		this.id=id;
		this.nombre=nombre;
		this.nacionalidad=nacionalidad;
		this.año_nacimiento=año_nacimiento;
	}

	/**
	 * Constructor de compositor en base a su id, nombre, nacionalidad, fecha de nacimiento y peliculas en las que ha participado
	 * @param id del compositor
	 * @param nombre del compositor
	 * @param nacionalidad del compositor
	 * @param año_nacimiento del compositor
	 * @param peliculas en las que ha participado el compositor
	 */
	public Compositor(int id, String nombre, String nacionalidad, int año_nacimiento, ArrayList<Pelicula> peliculas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.año_nacimiento = año_nacimiento;
		this.peliculas = peliculas;
	}

	/**
	* Constructor de compositor en base a su id, nombre, nacionalidad, fecha de nacimiento 
	 * @param id del compositor
	 * @param nombre del compositor
	 * @param nacionalidad del compositor
	 * @param año_nacimiento del compositor
	 */
	public Compositor(int id, String nombre, String nacionalidad, int año_nacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.año_nacimiento = año_nacimiento;
	}
	public Compositor() {
		
	}
	/*
	 * getter de id
	 */

	public int getId() {
		return id;
	}
	/*
	 * setter de id
	 */

	public void setId(int id) {
		this.id = id;
	}
/*
 * getter de nombre
 */
	public String getNombre() {
		return nombre;
	}
	/*
	 * setter de nombre
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * getter de nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	/*
	 * setter de nacionalidad
	 */

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	/*
	 * getter de año de nacimiento
	 */

	public int getAño_nacimiento() {
		return año_nacimiento;
	}
	/*
	 * setter de año de nacimiento
	 */

	public void setAño_nacimiento(int año_nacimiento) {
		this.año_nacimiento = año_nacimiento;
	}

	/*
	 * getter de peliculas
	 */
	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}
	/*
	 * setter de peliculas
	 */

	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
/*
 * toString para poder imprimir la informacion
 */
	@Override
	public String toString() {
		return " Id Compositor: " + id + " Nombre: " + nombre + " Nacionalidad: " + nacionalidad + " Año nacimiento: "
				+ año_nacimiento;
	}
	

}
