package model_food;

//Thịt nướng
public class Barbecue extends FoodDecorator {

	public Barbecue(Food food) {
		super(food);
	}

	public double cost() {
		return 10000 + food.cost();
	}

	@Override
	public String note() {
		return food.note() + " thêm thịt nướng,";
	}

}