package do_doi_that;

public class Modern extends VariantFactory {

	public Chair createChair() {
		return new ChairModern();
	}

	public Sofa createSofa() {
		return new SofaModern();
	}

	public CaffeTable createCoffeTable() {
		return new CaffeTableModern();
	}

}