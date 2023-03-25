package model_food;

import model_system.Size;

//Phô mai
public class Pizza extends Foods {
	private Size size;
	private String name;

	public Pizza(String url) {
		size = Size.MEDIUM;
		name = "Bánh pizza size ";
		this.urlImage = url;
	}

	public double cost() {
		return 25000 * size.getPercent();
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
		name += size.toString();
	}

	@Override
	public String note() {
		return name;
	}

	@Override
	public String toString() {
		return this.note();
	}

	@Override
	public boolean hasSize() {
		return true;
	}

}