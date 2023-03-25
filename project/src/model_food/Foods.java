package model_food;

import model_system.Size;

public abstract class Foods implements Food {
	protected String urlImage, name;
	protected Size size = Size.MEDIUM;
	protected double cost;


	public abstract boolean hasSize();

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
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

	public void setSize(Size size) {
		this.size = size;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return this.note() + " giá là " + this.cost();
	}
	
	
}
