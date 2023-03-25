package model_food;

//Xúc xích
public class Sausage extends FoodDecorator {
	public Sausage(Food food) {
		this.food = food;
	}

	public double cost() {
		return 5000 + food.cost();
	}

	@Override
	public String note() {
		return food.note() + " thêm xúc xích,";
	}

	@Override
	public String getName() {
		return "Xúc xích";
	}

}