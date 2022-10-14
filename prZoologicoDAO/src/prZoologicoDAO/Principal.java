package prZoologicoDAO;

public class Principal {

	public static void main(String[] args) {
		
		Animal a = new Animal ("Ardilla","Bosques",0.1);
		
		AnimalDAO.insertAnimal(a);

	}

}
