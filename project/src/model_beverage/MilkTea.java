package model_beverage;

import model_system.Size;

public class MilkTea implements Beverage {
	private Size size;
	private String name;
	
	public MilkTea(Size size) {
		super();
		this.size = size;
		this.name = "Trà sửa size " + size.toString();
	}



	public double cost() {
		return 20000*size.getPercent();
	}

	public Size getSize() {
		return size;
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
}