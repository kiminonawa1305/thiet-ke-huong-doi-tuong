package model_system;

import java.util.HashMap;

import model_beverage.*;
import model_food.*;

public class Bill {
	private String id;
	private HashMap<Beverage, Integer> listBeverage;
	private HashMap<Food, Integer> listFood;
	private double totalBill;

}