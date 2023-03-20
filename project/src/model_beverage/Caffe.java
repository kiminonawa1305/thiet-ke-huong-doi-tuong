package model_beverage;

public class Caffe implements Beverage {
	private String name;
	
	public Caffe() {
		super();
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
}