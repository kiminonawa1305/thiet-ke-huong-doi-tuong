package model_food;

import model_system.Size;

public class Test {
	public static void main(String[] args) {
			Food banhMi = new BanhMi();
			Food pizza = new Pizza(Size.LARGE);
			Food gaRan = new FriedChicken(Size.MEDIUM);
			
			System.out.println(banhMi.note() + " : " + banhMi.cost());
			System.out.println(pizza.note() + " : " + pizza.cost());
			System.out.println(gaRan.note() + " : " + gaRan.cost());
			
			banhMi = new Barbecue(banhMi);
			System.out.println(banhMi.note() + " : " + banhMi.cost());
			pizza = new Sausage(pizza);
			System.out.println(pizza.note() + " : " + pizza.cost());
			gaRan = new Cheese(gaRan);
			System.out.println(gaRan.note() + " : " + gaRan.cost());
	}
}
