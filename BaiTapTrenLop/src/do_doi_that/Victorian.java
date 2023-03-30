package do_doi_that;

public class Victorian extends VariantFactory {

	public Chair createChair() {
		return new ChairVictorian();
	}

	public Sofa createSofa() {
		return new SofaVictorian();
	}

	public CaffeTable createCoffeTable() {
		return new CaffeTableVictorian();
	}

}