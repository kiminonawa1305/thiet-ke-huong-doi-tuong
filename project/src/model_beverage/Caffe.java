package model_beverage;

public class Caffe extends Beverages {
	private String name;
	
	public Caffe(String url) {
		this.urlImage = url;
		this.name = "Caffe";
	}

	public double cost() {
		return 15000;
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