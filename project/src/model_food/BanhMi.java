package model_food;

public class BanhMi implements Food{
	private String name;
	
	public BanhMi() {
		super();
		this.name = "Bánh mì";
	}

	public double cost() {
		return 10000;
	}

	@Override
	public String note() {
		return name;
	}

}