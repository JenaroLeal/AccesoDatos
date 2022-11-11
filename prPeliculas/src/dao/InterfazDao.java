package dao;

import java.util.ArrayList;

public interface InterfazDao <T>{
	
	public ArrayList<T> buscarTodos();
	
	public T buscarporId(int i);
	
	public void insertar (T t);
	
	public void modificar (T t);
	
	public void borrar(T t);
	
	

}
