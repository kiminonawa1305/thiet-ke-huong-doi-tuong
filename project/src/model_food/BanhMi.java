package model_food;

public class BanhMi extends Foods{
	private String name;
	
	public BanhMi(String url) {
		this.urlImage = url;
		this.name = "Bánh mì";
	}

	public double cost() {
		return 10000;
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