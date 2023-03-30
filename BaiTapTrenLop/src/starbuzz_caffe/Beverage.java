package starbuzz_caffe;

public abstract class Beverage {
	protected String description = "Unknown Beverage";
	protected Size size;
	
	public Beverage(Size size) {
		this.size = size;
	}
	
	public Beverage() {
		this.size = Size.MEDIUM;
	}

	public String getDescription() {
		return this.description;
	}

	public abstract double cost();

	public void setSize(Size size) {
		this.size = size;
	}

	public Size getSize() {
		return this.size;
	}
	
	public static void main(String[] args) {
		Beverage beverage = new Expresso(Size.BIG);
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha("Thêm Mocha", beverage2);
//		beverage2 = new Mocha("Thêm Mocha lần 2", Size.SMALL, beverage2);
//		beverage2 = new Whip("Thêm Whip", Size.MEDIUM, beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
		Beverage beverage3 = new HouseBlend(Size.MEDIUM);
		beverage3 = new Soy("Thêm Soy", Size.MEDIUM, beverage3);
//		beverage3 = new Mocha("Thêm Mocha", Size.MEDIUM, beverage3);
//		beverage3 = new Whip("Thêm Whip", Size.MEDIUM, beverage3);
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
	}

}