package HeThongGameMoPhongSimUDuck3;

public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void performQuack() {
		this.quackBehavior.quack();
	}
	
	public void simming() {
		System.out.println("I am swimming");
	}
	
	public abstract void display();

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
	
}
