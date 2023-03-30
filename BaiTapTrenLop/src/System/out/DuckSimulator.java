package System.out;

import HeThongGameMoPhongSimUDuck3.DecoyDuck;
import HeThongGameMoPhongSimUDuck3.FlyNoWay;
import HeThongGameMoPhongSimUDuck3.FlyWithWings;
import HeThongGameMoPhongSimUDuck3.MallardDuck;
import HeThongGameMoPhongSimUDuck3.RubberDuck;

public class DuckSimulator {
	public static void main(String[] args) {
		MallardDuck mallard = new MallardDuck();
		RubberDuck rubberDuckie = new RubberDuck();
		DecoyDuck decoy = new DecoyDuck();
		
		mallard.display();
		mallard.performQuack();
		mallard.performFly();
		
		rubberDuckie.display();
		rubberDuckie.performQuack();
		rubberDuckie.performFly();
		
		decoy.display();
		decoy.performQuack();
		decoy.performFly();
		
		rubberDuckie.setFlyBehavior(new FlyWithWings());
		rubberDuckie.performFly();
		
		rubberDuckie.setFlyBehavior(new FlyNoWay());
		rubberDuckie.performFly();
	}
}
