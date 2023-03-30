package VideoRental;

public class RegularCharege implements ChargeComputing {

	@Override
	public double getCharge(int rentDays) {
		return rentDays < 3 ? 3000 : 3000 + (rentDays - 2)*1000;
	}

}
