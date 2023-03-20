package PizzaSF1;

public class PizzaStore {
	private SimplePizzaFactory factory;

	public PizzaStore(SimplePizzaFactory factory) {
		this.factory = factory;
	}

	public Pizza orderPizza(String type) {
		Pizza pizza;
		pizza = factory.createPizza(type);

		if(pizza == null) {
			System.out.println("We dont have any Pizza type that!");
			return null;
		}
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	public static void main(String[] args) {
		SimplePizzaFactory factory = new SimplePizzaFactory();
		PizzaStore store = new PizzaStore(factory);
		Pizza pizza = store.orderPizza("CheesePizza");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		pizza = store.orderPizza("VeggiePizza");
		System.out.println("We ordered a " + pizza.getName() + "\n");
	}
}
