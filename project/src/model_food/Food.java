package model_food;

public interface Food {
	public double cost();
	
	public String note();

	@Override
	boolean equals(Object obj);

	public Food clone();

	@Override
	int hashCode();
}