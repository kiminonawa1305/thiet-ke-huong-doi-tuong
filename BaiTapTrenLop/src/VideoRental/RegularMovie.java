package VideoRental;

public class RegularMovie extends Movie {

	public RegularMovie(String title) {
		super(title);
		this.chargeComputing = new RegularCharege();
		this.frequentRenterPoint = new RegularPoints();
	}

}
