package do_doi_that;

public class FurnitureShop {

	/**
	 * 
	 * @param VariantFactory
	 */
	public void sellChair(VariantFactory factory) {
		System.out.println("Đã bán " + factory.createChair());
	}

	/**
	 * 
	 * @param VariantFactory
	 */
	public void sellSofa(VariantFactory factory) {
		System.out.println("Đã bán " + factory.createSofa());
	}

	/**
	 * 
	 * @param VariantFactory
	 */
	public void sellCaffeTable(VariantFactory factory) {
		System.out.println("Đã bán " + factory.createCoffeTable());
	}

}