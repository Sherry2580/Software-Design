package onepackage;

public class one {
	public static void main(String[] args) {
		Animal myDog = new Dog();
		Animal myCat = new Cat();
		Animal mySheep = new Sheep();
		
		Animal[] animals = {myDog, myCat, mySheep};

		for (Animal animal : animals) {
			animalSound(animal);
		}

	}
	
	public static void animalSound(Animal animal) {
		animal.sound();
	}
}
