package prZoologicoDAO;

public class Animal {

	private int id;
	private String nombre;
	private String habitat;
	private double peso_aprox;

	public Animal(int id, String nombre, String habitat, double peso_aprox) {

		this.id = id;
		this.nombre = nombre;
		this.habitat = habitat;
		this.peso_aprox = peso_aprox;

	}

	public Animal(String nombre, String habitat, double peso_aprox) {

		this.nombre = nombre;
		this.habitat = habitat;
		this.peso_aprox = peso_aprox;
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

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public double getPeso_aprox() {
		return peso_aprox;
	}

	public void setPeso_aprox(double peso_aprox) {
		this.peso_aprox = peso_aprox;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombre=" + nombre + ", habitat=" + habitat + ", peso_aprox=" + peso_aprox + "]";
	}
	
	

}
