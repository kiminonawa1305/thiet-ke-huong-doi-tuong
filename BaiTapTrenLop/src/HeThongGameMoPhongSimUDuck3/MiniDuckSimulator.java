package HeThongGameMoPhongSimUDuck3;

public class MiniDuckSimulator {
	public static void main(String[] args) {
		ModelDuck model = new ModelDuck();
		model.display();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPower());
		model.performFly();
	}
}
