package model_pay;

import model_system.Bill;

public class Cash implements PayOption {

	@Override
	public boolean getPay(Bill bill,double thue, double moneyReceived) {
		return bill.getPay(thue) <= moneyReceived;
	}
}