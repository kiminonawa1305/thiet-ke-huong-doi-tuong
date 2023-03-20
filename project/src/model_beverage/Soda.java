package model_beverage;

import model_system.Size;

public class Soda implements Beverage {
	private Size size;
	private String name;
	
	
	public Soda(Size size) {
		super();
		this.size = size;
		name = "Soda size " + size.toString();
	}

	public double cost() {
		return 10000*size.getPercent();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Size getSize() {
		return size;
	}

	@Override
	public String note() {
		return name;
	}
}