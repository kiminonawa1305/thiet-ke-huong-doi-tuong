package model_beverage;

import model_system.Size;

public class Soda extends Beverages {
	private Size size;
	private String name;

	public Soda(String url) {
		this.urlImage = url;
		this.size = Size.MEDIUM;
		name = "Soda size ";
	}

	public double cost() {
		return 10000 * size.getPercent();
	}

	public String getName() {
		return name;
	}

	public void setSize(Size size) {
		this.size = size;
		name += size.toString();
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

	@Override
	public String toString() {
		return this.note();
	}
}