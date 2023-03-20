package PizzaFM;

public class ChicagoStylePizzaStore extends PizzaStore {
	public Pizza createPizza(String item) {
		Pizza pizza = null;
		switch (item) {
		case "VeggiePizza": {
			pizza = new ChicagoStyleVeggiePizza();
			break;
		}
		case "PepperoniPizza": {
			pizza = new ChicagoStylePepperoniPizza();
			break;
		}
		case "CheesePizza": {
			pizza = new ChicagoStyleCheesePizza();
			break;
		}
		case "ClamPizza": {
			pizza = new ChicagoStyleCheesePizza();
			break;
		}
		}

		return pizza;
	}
}
