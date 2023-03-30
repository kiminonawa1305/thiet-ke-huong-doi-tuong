package HeThongGameMoPhongSimUDuck2;

public class RubberDuck extends Duck implements Quackable {

	@Override
	public void quack() {
		System.out.println("Squick, squick ...");
	}

	@Override
	public void display() {
		System.out.println("I'm a rubber duck");
	}

}
