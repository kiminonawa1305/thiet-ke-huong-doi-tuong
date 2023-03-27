package model_beverage;

import model_system.Size;

public interface Beverage {

	public double cost();
	
	public String note();

	@Override
	boolean equals(Object obj);

	Beverage clone();

	@Override
	int hashCode();
}