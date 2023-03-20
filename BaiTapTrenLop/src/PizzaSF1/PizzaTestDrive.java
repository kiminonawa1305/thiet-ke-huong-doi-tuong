package PizzaSF1;

public class PizzaTestDrive {
	public static void main(String[] args) {
		SimplePizzaFactory factory = new SimplePizzaFactory();
		PizzaStore store = new PizzaStore(factory);
		Pizza pizza = store.orderPizza("PepperoniPizza");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		pizza = store.orderPizza("VeggiePizza");
		System.out.println("We ordered a " + pizza.getName() + "\n");
	}
}
