package model_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Consumer;

import model_pay.PayOption;
import model_beverage.*;
import model_food.*;

@SuppressWarnings("deprecation")
public class Outlets extends Observable implements Observer {
	private static int countId = 1;
	private String id = countId++ + "";
	private String name;
	private List<Employee> employees;
	private Employee manager;
	private List<Bill> listBill;
	private List<Food> listFood;
	private List<Beverage> listBeverage;

	public Outlets(String id, String name, List<Employee> employees, Employee manager, List<Bill> listBill,
			List<Food> listFood, List<Beverage> listBeverage, Observable observable) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
		this.manager = manager;
		this.listBill = listBill;
		this.listFood = listFood;
		this.listBeverage = listBeverage;
	}

	public Outlets(String id, String name, List<Bill> listBill, List<Food> listFood, List<Beverage> listBeverage,
			Observable observable) {
		super();
		this.id = id;
		this.name = name;
		this.listBill = listBill;
		this.listFood = listFood;
		this.listBeverage = listBeverage;
	}

	public Outlets(Systems systems) {
		systems.addObserver(this);
		this.addObserver(systems);

		this.listBeverage = systems.getListBeverage();
		this.listFood = systems.getListFood();
		this.listBill = new ArrayList<>();
	}

	public List<Food> getListFood() {
		return listFood;
	}

	public List<Beverage> getListBeverage() {
		return listBeverage;
	}

	/**
	 * 
	 * @param payOption
	 */
	public boolean pay(PayOption payOption, Bill bill, double moneyReceived) {
		return payOption.getPay(bill, moneyReceived);
	}

	/**
	 * 
	 * @param listFood
	 */
	public void order(HashMap<Food, Integer> listFood, HashMap<Beverage, Integer> listbeverage) {
		listBill.add(new Bill(listbeverage, listFood));
	}

	public double getTotalTurnover() {
		double re = 0;
		for (Bill bill : listBill) {
			re += bill.getTotalBill();
		}
		return re;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(((String)arg).equals("Thu nhap")) {
			this.setChanged();
			this.notifyObservers("Thu nhap\t" + id + "\t" + this.getTotalTurnover());
		}
	}
}