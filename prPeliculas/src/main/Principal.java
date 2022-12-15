package main;

import java.util.ArrayList;

import dao.CompositorDao;
import dao.PeliculaDao;
import pojo.Compositor;
import pojo.Pelicula;

public class Principal {

	public static void main(String[] args) {

		CompositorDao cd = new CompositorDao();

		PeliculaDao pd = new PeliculaDao();
		pd.eliminarTablaPelicula();
		cd.eliminarTablaCompositor();
		cd.crearTablaCompositores();
		pd.crearTablaPeliculas();
		
		
	

		Compositor c = new Compositor ("Hans Zimmer", "Alemania",1957);
		

		cd.insertar(c);
		
		Compositor cc =cd.buscarporId(1);
		
		
		
		Pelicula p = new Pelicula("ReyLeon",175,2018,cc);
		Pelicula p1 = new Pelicula ("El último Samurai",145,2015,cc);
		pd.insertar(p);
		pd.insertar(p1);
		
		ArrayList<Compositor> compositores = cd.buscarTodos();
		for(Compositor compositor : compositores) {
			System.out.println("Compositor: "+compositor.getNombre());
			for (Pelicula pelicula : compositor.getPeliculas()) {
				System.out.println("Pelicula: "+pelicula.getNombre());
			}
		}

		System.out.println(pd.peliculasPorDecada(2010, 2020));

	}

}
