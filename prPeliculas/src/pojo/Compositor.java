package pojo;

import java.util.ArrayList;

public class Compositor {
	
	private int id;
	private String nombre;
	private String nacionalidad;
	private int año_nacimiento;
	private ArrayList<Pelicula> peliculas;
	
	public Compositor (String nombre, String nacionalidad, int año_nacimiento) {
		super();
		this.id=id;
		this.nombre=nombre;
		this.nacionalidad=nacionalidad;
		this.año_nacimiento=año_nacimiento;
	}

	public Compositor(int id, String nombre, String nacionalidad, int año_nacimiento, ArrayList<Pelicula> peliculas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.año_nacimiento = año_nacimiento;
		this.peliculas = peliculas;
	}

	public Compositor(int id, String nombre, String nacionalidad, int año_nacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.año_nacimiento = año_nacimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getAño_nacimiento() {
		return año_nacimiento;
	}

	public void setAño_nacimiento(int año_nacimiento) {
		this.año_nacimiento = año_nacimiento;
	}

	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public String toString() {
		return " Id Compositor: " + id + " Nombre: " + nombre + " Nacionalidad: " + nacionalidad + " Año nacimiento: "
				+ año_nacimiento;
	}
	

}
