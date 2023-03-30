package HeThongGameMoPhongSimUDuck1;

public abstract class Duck {
	public void quack() {
		System.out.println("Quack, quack ...");
	}
	public void swim() {
		System.out.println("I am swimming");
	}
	public abstract void display();
	
	public void fly() {
		System.out.println("I am flying");
	}
}
