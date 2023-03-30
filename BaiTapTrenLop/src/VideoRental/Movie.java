package VideoRental;

public abstract class Movie {
	private boolean availabe;
	private String title;
	protected ChargeComputing chargeComputing;
	protected FrequentRenterPoint frequentRenterPoint;
	public Movie(String title) {
		super();
		this.title = title;
	}
	public boolean isAvailabe() {
		return availabe;
	}
	public void setAvailabe(boolean availabe) {
		this.availabe = availabe;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ChargeComputing getChargeComputing() {
		return chargeComputing;
	}
	public void setChargeComputing(ChargeComputing chargeComputing) {
		this.chargeComputing = chargeComputing;
	}
	public FrequentRenterPoint getFrequentRenterPoint() {
		return frequentRenterPoint;
	}
	public void setFrequentRenterPoint(FrequentRenterPoint frequenRenterPoint) {
		this.frequentRenterPoint = frequentRenterPoint;
	}
	
	public double getCharge(int rentDays) {
		return this.chargeComputing.getCharge(rentDays);
	}
	
	public int getFrequentRenterPoints(int renDays) {
		return this.frequentRenterPoint.getPoints(renDays);
	}
}
