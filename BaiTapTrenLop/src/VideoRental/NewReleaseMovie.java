package VideoRental;

public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title);
		this.chargeComputing = new NewReleaseCharge();
		this.frequentRenterPoint = new NewReleasePoints();
	}

}
