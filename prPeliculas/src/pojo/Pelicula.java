package pojo;

/**
 * Clase Pelicula para poder construir peliculas en funcion de distintos argumentos
 * @author jenaro
 *
 */
public class Pelicula {
	
	//id de la pelicula
	private int id;
	//nombre de la pelicula
	private String nombre;
	//duracion de la pelicula
	private int duracion;
	//año de lanzamiento de la pelicula
	private int año_lanzamiento;
	//Compositor que ha compuesto la pelicula
	private Compositor compositor;
	//Id del compositor que ha compuesto la pelicula
	private int compositor_id;
	/**
	 * Constructor de pelicula en base a su nombre, duracion, año de lanzamiento y compositor
	 * @param nombre de la pelicula
	 * @param duracion de la pelicula
	 * @param año_lanzamiento de la pelicula
	 * @param compositor que ha compuesto la pelicula
	 */
	public Pelicula(String nombre, int duracion, int año_lanzamiento, Compositor compositor) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.año_lanzamiento = año_lanzamiento;
		this.compositor = compositor;
	}
	/**
	 * * Constructor de pelicula en base a su id, nombre, duracion, año de lanzamiento y compositor
	 * @param id de la pelicula
	 * @param nombre de la pelicula
	 * @param duracion de la pelicula
	 * @param año_lanzamiento de la pelicula
	 * @param compositor que ha compuesto la pelicula
	 */
	public Pelicula(int id, String nombre, int duracion, int año_lanzamiento, Compositor compositor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.año_lanzamiento = año_lanzamiento;
		this.compositor = compositor;
	}
	/**
	 * Constructor de pelicula en base a su id, nombre, duracion, año de lanzamiento y compositor 
		@param id de la pelicula
	 * @param nombre de la pelicula
	 * @param duracion de la pelicula
	 * @param año_lanzamiento de la pelicula
	 */
	public Pelicula(int id, String nombre, int duracion, int año_lanzamiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.año_lanzamiento = año_lanzamiento;
		
	}
	/**
	 * Constructor de pelicula en base a su id, nombre, duracion, año de lanzamiento y el id del compositor 
		@param id de la pelicula
	 * @param nombre de la pelicula
	 * @param duracion de la pelicula
	 * @param año_lanzamiento de la pelicula
	 * @param compositor_id id del compositor de la pelicula
	 */
	public Pelicula(int id, String nombre, int duracion, int año_lanzamiento, int compositor_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.año_lanzamiento = año_lanzamiento;
		this.compositor_id=compositor_id;
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
	 * getter de duracion
	 */
	public int getDuracion() {
		return duracion;
	}
	/*
	 * setter de duracion
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	/*
	 * getter de año de lanzamiento
	 */
	public int getAño_lanzamiento() {
		return año_lanzamiento;
	}
	/*
	 * setter de año de lanzamiento
	 */
	public void setAño_lanzamiento(int año_lanzamiento) {
		this.año_lanzamiento = año_lanzamiento;
	}
	/*
	 * getter de compositor
	 */
	public Compositor getCompositor() {
		return compositor;
	}
	/*
	 * setter de compositor
	 */
	public void setCompositor(Compositor compositor) {
		this.compositor = compositor;
	}
	/*
	 * getter de compositor id
	 */
	public int getCompositor_id() {
		return compositor_id;
	}
	/*
	 * setter de compositor id
	 */
	public void setCompositor_id(int compositor_id) {
		this.compositor_id = compositor_id;
	}
	/*
	 * toString para pdoer imprimir la informacion
	 */
	@Override
	public String toString() {
		return "Nombre: " + nombre + ". Duracion: " + duracion + ". Año lanzamiento: " + año_lanzamiento+"\n";
				
	}
	
	
	

}
