package pojo.pojo;
// Generated 25 nov. 2022 14:23:28 by Hibernate Tools 5.5.9.Final

/**
 * Temporadas generated by hbm2java
 */
public class Temporadas implements java.io.Serializable {

	private Integer id;
	private Series series;
	private int numTemporadas;
	private String titulo;

	public Temporadas() {
	}

	public Temporadas(Series series, int numTemporadas, String titulo) {
		this.series = series;
		this.numTemporadas = numTemporadas;
		this.titulo = titulo;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Series getSeries() {
		return this.series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public int getNumTemporadas() {
		return this.numTemporadas;
	}

	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}