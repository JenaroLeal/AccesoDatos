package dao;

import java.util.ArrayList;

public interface InterfazDao <T>{
	
	
	/**
	 * Muestra todos los objetos T de la base de datos
	 * 
	 * @return un ArrayyList de objetos T
	 */
	public ArrayList<T> buscarTodos();
	/**
	 * Muestra el objeto T con el id especificado de la base de datos
	 * @param i el id que queremos buscar y obtener la info
	 * @return un objeto T
	 */
	public T buscarPorId(int i);
	
	/**
	 * inserta el objeto T en la base de datos
	 * @param t un objeto T
	 */
	
	public void insertar(T t);
	
	/**
	 * Actualiza el objeto T de la base de datos
	 * @param t un objeto T
	 */
	
	public void modificar (T t);
	
	/**
	 * Elimina el objeto T de la base de datos
	 * @param t el objeto t que queremos eliminar
	 */
	
	public void borrar (T t);
	
	
}
