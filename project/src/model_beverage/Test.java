package model_beverage;

import model_system.Size;

public class Test {
	public static void main(String[] args) {
		Beverage cafe = new Caffe();
		Beverage soda = new Soda(Size.LARGE);
		Beverage milkTea = new MilkTea(Size.MEDIUM);
		
		System.out.println(cafe.note() + " : " + cafe.cost());
		System.out.println(soda.note() + " : " + soda.cost());
		System.out.println(milkTea.note() + " : " + milkTea.cost());
		
		cafe = new Sugar(cafe);
		System.out.println(cafe.note() + " : " + cafe.cost());
		soda = new Lemon(soda);
		System.out.println(soda.note() + " : " + soda.cost());
		milkTea = new Milk(milkTea);
		System.out.println(milkTea.note() + " : " + milkTea.cost());
	}
}
