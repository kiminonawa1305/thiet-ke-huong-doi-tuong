package model_beverage;

public class Lemon extends CondimentDecorator {

	public Lemon(Beverage beverage) {
		super(beverage);
	}

	public double cost() {
		return 1000 + beverage.cost();
	}

	@Override
	public String note() {
		return beverage.note() + " thêm chanh,";
	}
}