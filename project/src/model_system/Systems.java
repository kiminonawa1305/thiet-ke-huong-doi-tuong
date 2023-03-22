package model_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import model_beverage.*;
import model_food.*;

@SuppressWarnings("deprecation")
public class Systems extends Observable implements Observer {
	private List<Beverage> listBeverage;
	private List<Food> listFood;
	private Map<String, Double> listTurnover;

	public Systems(List<Beverage> listBeverage, List<Food> listFood) {
		super();
		this.listBeverage = listBeverage;
		this.listFood = listFood;
		listTurnover = new HashMap<>();
	}

	public List<Beverage> getListBeverage() {
		return this.listBeverage;
	}

	public List<Food> getListFood() {
		return listFood;
	}

	/**
	 * 
	 * @param id
	 */
	public void getTurnoverOfOutlets(String id) {
		throw new UnsupportedOperationException();
	}

	public void getTotalTurnover() {
		this.setChanged();
		this.notifyObservers("Thu nhap");
	}

	@Override
	public void update(Observable o, Object arg) {
		if (((String) arg).split("\t")[0].equals("Thu nhap")) {
			this.listTurnover.put(((String) arg).split("\t")[0] + " " + ((String) arg).split("\t")[1],
					Double.parseDouble(((String) arg).split("\t")[2]));
		}
	}

	public static void main(String[] args) {
		Beverage cafe = new Caffe();
		Beverage soda = new Soda(Size.LARGE);
		Beverage milkTea = new MilkTea(Size.MEDIUM);
		List<Beverage> listBeverage = new ArrayList<>();
		listBeverage.add(cafe);
		listBeverage.add(soda);
		listBeverage.add(milkTea);

		Food banhMi = new BanhMi();
		Food pizza = new Pizza(Size.LARGE);
		Food gaRan = new FriedChicken(Size.MEDIUM);
		List<Food> listFood = new ArrayList<>();
		listFood.add(banhMi);
		listFood.add(pizza);
		listFood.add(gaRan);

		Systems system = new Systems(listBeverage, listFood);
		Outlets outlets1 = new Outlets(system);
		Outlets outlets2 = new Outlets(system);
		Outlets outlets3 = new Outlets(system);
		Outlets outlets4 = new Outlets(system);

		System.out.println(outlets1.getListFood());
		System.out.println(outlets2.getListFood());
		System.out.println(outlets3.getListFood());
		System.out.println(outlets4.getListFood());

		system.getTotalTurnover();
		System.out.println(system.listTurnover);

		HashMap<Food, Integer> listFood1 = new HashMap<>();
		listFood1.put(gaRan, 1);

		HashMap<Beverage, Integer> listBeverage1 = new HashMap<>();

		System.out.println(outlets1.getTotalTurnover());
		outlets1.order(listFood1, listBeverage1);
		System.out.println(outlets1.getTotalTurnover());

		system.getTotalTurnover();
		System.out.println(system.listTurnover);
	}
}