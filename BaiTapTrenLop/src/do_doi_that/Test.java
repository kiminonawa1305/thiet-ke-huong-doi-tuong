package do_doi_that;

public class Test {
	public static void main(String[] args) {
		FurnitureShop furnitureShop = new FurnitureShop();
		VariantFactory victorian = new Victorian();
		VariantFactory modern = new Modern();
		VariantFactory artDeco = new ArtDeco();
		furnitureShop.sellChair(modern);
		furnitureShop.sellChair(artDeco);
		furnitureShop.sellChair(victorian);
		System.out.println("==========================================");
		furnitureShop.sellSofa(modern);
		furnitureShop.sellSofa(artDeco);
		furnitureShop.sellSofa(victorian);
		System.out.println("==========================================");
		furnitureShop.sellCaffeTable(modern);
		furnitureShop.sellCaffeTable(artDeco);
		furnitureShop.sellCaffeTable(victorian);
	}
}
