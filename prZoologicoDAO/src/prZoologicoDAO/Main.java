package prZoologicoDAO;

public class Main {

	public static void main(String[] args) {
Animal a = new Animal ("Ardilla","Bosques",0.1);
		
		AnimalDAO.insertAnimal(a);
	}

}
