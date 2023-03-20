package model_system;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model_beverage.*;
import model_food.*;

@SuppressWarnings("deprecation")
public class Systems extends Observable implements Observer{
	private List<Beverage> listBeverage;
	private List<Food> listFood;

	public List<Beverage> getListBeverage() {
		return this.listBeverage;
	}

	/**
	 * 
	 * @param id
	 */
	public void getTurnoverOfOutlets(String id) {
		// TODO - implement Systems.getTurnoverOfOutlets
		throw new UnsupportedOperationException();
	}

	public void getTotalTurnover() {
		// TODO - implement Systems.getTotalTurnover
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}