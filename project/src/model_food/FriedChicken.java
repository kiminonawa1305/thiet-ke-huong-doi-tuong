package model_food;

import model_system.Size;

public class FriedChicken implements Food {
	private Size size;
	private String name;

	public FriedChicken(Size size) {
		this.size = size;
		name = "Gà rán";
	}

	public double cost() {
		return 25000 * size.getPercent();
	}

	@Override
	public String note() {
		return name;
	}

}