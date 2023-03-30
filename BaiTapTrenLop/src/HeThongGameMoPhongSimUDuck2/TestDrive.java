package HeThongGameMoPhongSimUDuck2;

public class TestDrive {
	public static void main(String[] args) {
		Duck marllard = new MarllardDuck();
		Duck rubber = new RubberDuck();
		Duck decoy = new DecoyDuck();
		
		marllard.display();
		((Quackable) marllard).quack();
		((Flyable) marllard).fly();
		
		rubber.display();
		
		((Quackable) rubber).quack();
		decoy.display();
		decoy.swim();
	}
}
