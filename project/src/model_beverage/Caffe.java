package model_beverage;

import model_system.Size;

public class Caffe extends Beverages {
	public Caffe(String url) {
		this.urlImage = url;
		this.name = "Caffe";
		this.cost = 15000;
	}
	
	public Caffe(Size size) {
		this.size = size;
		this.name = "Caffe";
		this.cost = 15000;
	}

	public double cost() {
		return this.cost * size.getPercent();
	}

	@Override
	public String note() {
		return name + " size " + size;
	}
	
	@Override
	public String toString() {
		return this.note();
	}
}