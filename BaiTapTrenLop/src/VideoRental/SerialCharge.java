package VideoRental;

public class SerialCharge implements ChargeComputing {

	@Override
	public double getCharge(int rentDays) {
		// TODO Auto-generated method stub
		return rentDays < 3 ? 2000 : 2000 + (rentDays - 2)*1000;
	}

}
