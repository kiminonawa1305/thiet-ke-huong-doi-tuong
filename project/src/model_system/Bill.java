package model_system;

import java.util.HashMap;
import java.util.Map.Entry;

import model_beverage.*;
import model_food.*;

public class Bill {
	private static int countID = 1;
	private String id = countID++ + "";
	private HashMap<Beverage, Integer> listBeverage;
	private HashMap<Food, Integer> listFood;
	private double totalBill;

	public Bill(HashMap<Beverage, Integer> listBeverage, HashMap<Food, Integer> listFood) {
		super();
		this.id = id;
		this.listBeverage = listBeverage;
		this.listFood = listFood;
	}

	public Bill(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<Beverage, Integer> getListBeverage() {
		return listBeverage;
	}

	public void setListBeverage(HashMap<Beverage, Integer> listBeverage) {
		this.listBeverage = listBeverage;
	}

	public HashMap<Food, Integer> getListFood() {
		return listFood;
	}

	public void setListFood(HashMap<Food, Integer> listFood) {
		this.listFood = listFood;
	}

	public double getTotalBill() {
		for(Entry<Food, Integer> entryFood : listFood.entrySet()) {
			totalBill += entryFood.getKey().cost() * entryFood.getValue();
		}
		
		for(Entry<Beverage, Integer> entryBeverage : listBeverage.entrySet()) {
			totalBill += entryBeverage.getKey().cost() * entryBeverage.getValue();
		}
		
		return totalBill;
	}
}