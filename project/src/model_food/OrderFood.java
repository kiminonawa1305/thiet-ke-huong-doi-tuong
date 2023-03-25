package model_food;

import model_system.Size;

public class OrderFood extends Foods {
	private String name;
	private double cost;
	private boolean hasSize = false;
	private Size size;

	public OrderFood(String url, String name, double cost, boolean hasSize) {
		super();
		this.urlImage = url;
		this.name = name;
		this.cost = cost;
		this.hasSize = hasSize;
		size = Size.MEDIUM;
	}
	
	public OrderFood(String url, String name, double cost) {
		super();
		this.urlImage = url;
		this.name = name;
		this.cost = cost;
		size = Size.MEDIUM;
	}

	@Override
	public double cost() {
		return cost * size.getPercent();
	}

	@Override
	public boolean hasSize() {
		return hasSize;
	}

	public String note() {
		return name;
	}

	public Size getSize() {
		if(hasSize) {
			return size;
		}else {
			return null;
		}
	}

	public void setSize(Size size) {
		if(hasSize) {
			this.size = size;
		}
	}
}
