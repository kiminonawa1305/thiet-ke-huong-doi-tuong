package VideoRental;

public class NewReleasePoints implements FrequentRenterPoint {

	@Override
	public int getPoints(int rentDays) {
		// TODO Auto-generated method stub
		return rentDays > 1 ? 2 : 1;
	}

}
