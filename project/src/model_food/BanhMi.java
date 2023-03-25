package model_food;

public class BanhMi extends Foods{
	public BanhMi(String url) {
		this.urlImage = url;
		this.name = "Bánh mì";
		this.cost = 10000;
	}

	public double cost() {
		return this.cost;
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
		return false;
	}
	
}