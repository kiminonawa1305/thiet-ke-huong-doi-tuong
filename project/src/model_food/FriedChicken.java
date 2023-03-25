package model_food;

import model_system.Size;

public class FriedChicken extends Foods {
	private String urlImage;
	private Size size;
	private String name;

	public FriedChicken(String url) {
		name = "Gà rán";
		size = Size.MEDIUM;
		this.urlImage = url;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
		name += size.toString();
	}

	public double cost() {
		return 25000 * size.getPercent();
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