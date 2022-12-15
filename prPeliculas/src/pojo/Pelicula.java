package pojo;

public class Pelicula {
	
	private int id;
	private String nombre;
	private int duracion;
	private int año_lanzamiento;
	private Compositor compositor;
	private int compositor_id;
	public Pelicula(String nombre, int duracion, int año_lanzamiento, Compositor compositor) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.año_lanzamiento = año_lanzamiento;
		this.compositor = compositor;
	}
	public Pelicula(int id, String nombre, int duracion, int año_lanzamiento, Compositor compositor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.año_lanzamiento = año_lanzamiento;
		this.compositor = compositor;
	}
	public Pelicula(int id, String nombre, int duracion, int año_lanzamiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.año_lanzamiento = año_lanzamiento;
		
	}
	public Pelicula(int id, String nombre, int duracion, int año_lanzamiento, int compositor_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.año_lanzamiento = año_lanzamiento;
		this.compositor_id=compositor_id;
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
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getAño_lanzamiento() {
		return año_lanzamiento;
	}
	public void setAño_lanzamiento(int año_lanzamiento) {
		this.año_lanzamiento = año_lanzamiento;
	}
	public Compositor getCompositor() {
		return compositor;
	}
	public void setCompositor(Compositor compositor) {
		this.compositor = compositor;
	}
	
	public int getCompositor_id() {
		return compositor_id;
	}
	public void setCompositor_id(int compositor_id) {
		this.compositor_id = compositor_id;
	}
	@Override
	public String toString() {
		return "Nombre: " + nombre + ". Duracion: " + duracion + ". Año lanzamiento: " + año_lanzamiento+"\n";
				
	}
	
	
	

}
