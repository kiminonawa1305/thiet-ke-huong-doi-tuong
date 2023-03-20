package model_system;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import model_pay.PayOption;
import model_beverage.*;
import model_food.*;

@SuppressWarnings("deprecation")
public class Outlets  extends Observable implements Observer{
	private String id;
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
	
	public Outlets(String id, String name, List<Bill> listBill,
			List<Food> listFood, List<Beverage> listBeverage, Observable observable) {
		super();
		this.id = id;
		this.name = name;
		this.listBill = listBill;
		this.listFood = listFood;
		this.listBeverage = listBeverage;
	}
	
	public Outlets(Observable observable) {
		if(observable instanceof Systems) {
			observable.addObserver(this);
		}
	}

	/**
	 * 
	 * @param payOption
	 */
	public boolean pay(PayOption payOption) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listFood
	 */
	public void order(Map<Food, Integer> listFood) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}