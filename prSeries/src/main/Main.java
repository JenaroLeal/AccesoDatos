package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		
		//Serie serie = new Serie ("Los Simpsons",7,"Disney+");
		SerieDao serieDao = new SerieDao();
		/*
		//serieDao.insertar(serie);

		//Serie serie = serieDao.buscarPorId(1);
		//Temporada t1 = new Temporada(1,"Temporada 1",serie);
		//Temporada t2 = new Temporada(2,"Temporada 2",serie);
		
		//TemporadaDao tDao = new TemporadaDao();
		//tDao.insertar(t1);
		//tDao.insertar(t2);
		
		Serie los_simpson = serieDao.buscarPorId(1);
		los_simpson.setPlataforma("Netflix");
		
		ArrayList<Temporada> temporadas = serieDao.obtenerTemporadas(los_simpson);
		
		for(Temporada temporada : temporadas) {
			System.out.println(temporada);
		}
	*/
		ArrayList<Serie> series = serieDao.buscarTodos();
		for(Serie serie : series) {
			System.out.println("Serie: "+serie.getTitulo());
			for(Temporada temporada : serie.getTemporadas()) {
				System.out.println("Temporada: "+temporada.getTitulo());
			}
		}
		
		
	}
	

}
