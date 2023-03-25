package model_beverage;

import model_system.Size;

public class MilkTea extends Beverages {
	private Size size;

	public MilkTea(String url) {
		this.urlImage = url;
		this.name =  "Trà sửa";
		this.cost = 20000;
	}
	
	public MilkTea(Size size) {
		this.size = size;
		this.name =  "Trà sửa";
		this.cost = 20000;
	}

	public double cost() {
		return this.cost * size.getPercent();
	}

	@Override
	public String note() {
		return name + " size " + size.toString();
	}
	
	@Override
	public String toString() {
		return this.note();
	}
}