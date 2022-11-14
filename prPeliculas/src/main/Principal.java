package main;

import dao.CompositorDao;
import dao.PeliculaDao;
import pojo.Compositor;
import pojo.Pelicula;

public class Principal {

	public static void main(String[] args) {
		CompositorDao cd = new CompositorDao();
		PeliculaDao pd = new PeliculaDao();
		
		Compositor c = new Compositor ("Hans Zimmer", "Alemania",1957);
		cd.insertar(c);
		
		Compositor cc =cd.buscarporId(c.getId());
		
		Pelicula p = new Pelicula("ReyLeon",175,2018,cc);
		pd.insertar(p);
		
		
		
	}

}
