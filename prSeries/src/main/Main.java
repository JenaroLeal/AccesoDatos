package main;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		
		//Serie serie = new Serie ("Los Simpsons",7,"Disney+");
		SerieDao serieDao = new SerieDao();
		//serieDao.insertar(serie);

		Serie serie = serieDao.buscarPorId(1);
		Temporada t1 = new Temporada(1,"Temporada 1",serie);
		Temporada t2 = new Temporada(2,"Temporada 2",serie);
		
		TemporadaDao tDao = new TemporadaDao();
		tDao.insertar(t1);
		tDao.insertar(t2);
	}

}
