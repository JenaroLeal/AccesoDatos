package pojo;

public class Pelicula {
	
	private int id;
	private String nombre;
	private int duracion;
	private int año_lanzamiento;
	private Compositor compositor;
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
	@Override
	public String toString() {
		return "Nombre: " + nombre + ". Duracion: " + duracion + ". Año lanzamiento: " + año_lanzamiento
				+ ". Compositor: " + compositor.getNombre();
	}
	
	

}
