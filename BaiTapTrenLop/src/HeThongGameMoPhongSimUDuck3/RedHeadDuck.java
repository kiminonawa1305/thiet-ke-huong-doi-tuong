package HeThongGameMoPhongSimUDuck3;

public class RedHeadDuck extends Duck {
	public RedHeadDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("I am a red head duck");
	}

}
