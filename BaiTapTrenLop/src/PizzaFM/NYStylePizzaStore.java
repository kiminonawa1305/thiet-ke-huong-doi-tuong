package PizzaFM;

public class NYStylePizzaStore extends PizzaStore {
	public Pizza createPizza(String item) {
		Pizza pizza = null;
		switch (item) {
		case "VeggiePizza": {
			pizza = new NYStyleVeggiePizza();
			break;
		}
		case "PepperoniPizza": {
			pizza = new NYStylePepperoniPizza();
			break;
		}
		case "CheesePizza": {
			pizza = new NYStyleCheesePizza();
			break;
		}
		case "ClamPizza": {
			pizza = new NYStyleClamPizza();
			break;
		}
		}

		return pizza;
	}
}
