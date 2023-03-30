package do_doi_that;

public class ArtDeco extends VariantFactory {

	public Chair createChair() {
		return new ChairArtDeco();
	}

	public Sofa createSofa() {
		return new SofaArtDeco();
	}

	public CaffeTable createCoffeTable() {
		return new CaffeTableArtDeco();
	}

}