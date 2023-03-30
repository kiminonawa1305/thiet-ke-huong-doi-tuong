package HeThongGameMoPhongSimUDuck2;

public class RedHeadDuck extends Duck implements Flyable, Quackable {

	@Override
	public void quack() {
		System.out.println("Quack, quack ...");
	}

	@Override
	public void fly() {
		System.out.println("I'm flying");
	}

	@Override
	public void display() {
		System.out.println("I'm a red head duck");
	}

}
