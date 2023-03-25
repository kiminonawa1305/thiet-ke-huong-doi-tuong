package model_beverage;

import model_system.Size;

public class MilkTea extends Beverages {
	private Size size;
	private String name;

	public MilkTea(String url) {
		this.urlImage = url;
		this.size = Size.MEDIUM;
		this.name = "Trà sửa size ";
	}

	public double cost() {
		return 20000 * size.getPercent();
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
		name += size.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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