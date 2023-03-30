package VideoRental;

public class ChildrenCharge implements ChargeComputing {

	@Override
	public double getCharge(int rentDays) {
		// TODO Auto-generated method stub
		return rentDays < 4 ? 2500 : 2500 + (rentDays - 3)*1500;
	}

}
