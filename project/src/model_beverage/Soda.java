package model_beverage;

import model_system.Size;

public class Soda extends Beverages {
	public Soda(String url) {
		this.urlImage = url;
		this.name = "Soda";
		this.cost = 10000;
	}
	
	public Soda(Size size) {
		this.name = "Soda";
		this.size = size;
		this.cost = 10000;
	}

	public double cost() {
		return this.cost * size.getPercent();
	}

	@Override
	public String note() {
		return name + " size " + size;
	}
}