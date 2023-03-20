package PizzaSF1;

public class SimplePizzaFactory {

	public Pizza createPizza(String type) {
		Pizza pizza = null;
		switch (type) {
		case "VeggiePizza": {
			pizza = new VeggiePizza();
			break;
		}
		case "PepperoniPizza": {
			pizza = new PepperoniPizza();
			break;
		}
		case "CheesePizza": {
			pizza = new CheesePizza();
			break;
		}
		case "ClamPizza": {
			pizza = new ClamPizza();
			break;
		}
		}

		return pizza;
	}
}
