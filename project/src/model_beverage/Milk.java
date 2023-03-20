package model_beverage;

public class Milk extends CondimentDecorator {
	public Milk(Beverage beverage) {
		super(beverage);
	}

	public double cost() {
		return 2000 + beverage.cost();
	}

	@Override
	public String note() {
		return beverage.note() + " thêm sửa,";
	}
}