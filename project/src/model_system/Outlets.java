package model_system;

import java.util.List;
import java.util.Map;

import model_pay.PayOption;
import model_beverage.*;
import model_food.*;

public class Outlets {

	private String id;
	private String name;
	private List<Employee> employees;
	private Employee manager;
	private List<Bill> listBill;
	private List<Food> listFood;
	private List<Beverage> listBeverage;

	/**
	 * 
	 * @param payOption
	 */
	public boolean pay(PayOption payOption) {
		// TODO - implement Outlets.pay
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listFood
	 */
	public void order(Map<Food, Integer> listFood) {
		// TODO - implement Outlets.order
		throw new UnsupportedOperationException();
	}

}