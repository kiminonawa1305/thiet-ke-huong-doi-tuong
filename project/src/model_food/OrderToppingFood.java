package model_food;

import model_system.Size;

public class OrderToppingFood extends FoodDecorator {
	private String name;
	private double cost;
	
	public OrderToppingFood(String name, double cost, Food food) {
		this.name = name;
		this.cost = cost;
		this.food = food;
	}
	
	public OrderToppingFood(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	@Override
	public String note() {
		return food.note() + " thêm " + name;
	}

	@Override
	public double cost() {
		if(food == null) {
			return cost;
		}
		return cost + food.cost();
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void setFood(Food food) {
		this.food = food;
	}
	
	public static void main(String[] args) {
		Food food = new OrderFood("", "", 15000, true);
		((OrderFood)food).setSize(Size.SMALL);
		food = new OrderToppingFood("Đường", 1300, food);
		System.out.println(food.cost());
	}
}
