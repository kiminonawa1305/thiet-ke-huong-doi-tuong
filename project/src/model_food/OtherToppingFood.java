package model_food;

import model_system.Size;

public class OtherToppingFood extends FoodDecorator {
	public OtherToppingFood(String name, double cost, Food food) {
		this.name = name;
		this.cost = cost;
		this.food = food;
	}
	
	public OtherToppingFood(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	@Override
	public String note() {
		return food.note() + " thêm " + name;
	}

	@Override
	public double cost() {
		return cost + food.cost();
	}

	@Override
	public String getName() {
		return name;
	}
	
	public Food setFood(Food food) {
		this.food = food;
		return this;
	}
	
	@Override
	public String toString() {
		return this.note() + " giá là " + this.cost();
	}

	public static void main(String[] args) {
		Food food = new OtherFood("", "", 15000, true);
		((OtherFood)food).setSize(Size.SMALL);
		food = new OtherToppingFood("Đường", 1300, food);
		System.out.println(food.cost());
	}
}
