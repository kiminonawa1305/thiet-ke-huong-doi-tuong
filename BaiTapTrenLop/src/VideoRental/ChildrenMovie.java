package VideoRental;

public class ChildrenMovie extends Movie {

	public ChildrenMovie(String title) {
		super(title);
		this.chargeComputing = new ChildrenCharge();
		this.frequentRenterPoint = new RegularPoints();
	}

}
