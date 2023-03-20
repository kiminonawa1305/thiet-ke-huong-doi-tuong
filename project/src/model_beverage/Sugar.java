package model_beverage;

public class Sugar extends CondimentDecorator {
	
	public Sugar(Beverage beverage) {
		super(beverage);
	}

	public double cost() {
		return 1000 + beverage.cost();
	}

	@Override
	public String note() {
		return beverage.note() + " thêm đường,";
	}
}