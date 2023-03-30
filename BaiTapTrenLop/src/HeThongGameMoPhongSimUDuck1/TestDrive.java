package HeThongGameMoPhongSimUDuck1;

public class TestDrive {
	public static void main(String[] args) {
		Duck marllard = new MarllardDuck();
		Duck redHead = new RedHeadDuck();
		Duck rubber = new RubberDuck();
		Duck decoy = new DecoyDuck();
		
		marllard.display();
		marllard.swim();
		marllard.quack();
		
		redHead.display();
		redHead.swim();
		redHead.quack();
		
		rubber.display();
		rubber.swim();
		rubber.quack();
		
		decoy.display();
		decoy.swim();
		decoy.quack();
	}
}
