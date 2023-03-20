package model_food;

import model_system.Size;

//Phô mai
public class Pizza implements Food{
	private Size size;
	private String name;

	public Pizza(Size size) {
		super();
		this.size = size;
		name = "Bánh pizza size" + size.toString();
	}

	public double cost() {
		return 25000*size.getPercent();
	}

	@Override
	public String note() {
		// TODO Auto-generated method stub
		return name;
	}

}